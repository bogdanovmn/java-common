package com.github.bogdanovmn.common.concurrent;

import com.github.bogdanovmn.common.log.Duration;
import com.github.bogdanovmn.common.log.Timer;
import com.github.bogdanovmn.humanreadablevalues.MillisecondsValue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
public class ConcurrentConsuming {
    private final int poolSize;

    private AtomicInteger processed;
    private AtomicLong totalSpendCpuTimeInMills;
    private volatile boolean hasError;

    public synchronized <T> void consume(List<T> itemsToProcess, Consumer<T> processing) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        int totalItems = itemsToProcess.size();
        Timer totalTimer = Timer.start();
        processed = new AtomicInteger(0);
        totalSpendCpuTimeInMills = new AtomicLong(0);
        try {
            for (T item : itemsToProcess) {
                executorService.submit(
                    () -> {
                        try {
                            totalSpendCpuTimeInMills.addAndGet(
                                Duration.inMills(() -> processing.accept(item))
                            );
                        } catch (Exception ex) {
                            log.error(ex.getMessage());
                            hasError = true;
                        } finally {
                            processed.incrementAndGet();
                        }
                    });
            }
        } finally {
            executorService.shutdown();
            while (!executorService.awaitTermination(3, TimeUnit.SECONDS)) {
                logProgress(totalItems);
                if (hasError) {
                    log.warn("Force thread pool shutdown");
                    executorService.shutdownNow();
                }
            }
            logProgress(totalItems);
            log.info(
                "Total processing time: {}",
                    new MillisecondsValue(totalTimer.durationInMills()).shortString()
            );
        }

    }

    private void logProgress(int totalItems) {
        log.info(
            "Items processed: {}/{}. Avg processing time: {}",
                processed.get(),
                totalItems,
                processed.get() > 0
                    ? new MillisecondsValue(totalSpendCpuTimeInMills.get() / processed.get()).shortString()
                    : 0
            );
    }
}
