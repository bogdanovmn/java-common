package com.github.bogdanovmn.common.log;

import com.github.bogdanovmn.humanreadablevalues.MillisecondsValue;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class Duration {
    private Duration() {
    }

    public static <T> T log(String description, Supplier<T> supplier) {
        long start = System.currentTimeMillis();
        T result = supplier.get();
        log.info(
            String.format(
                "%s took %s",
                    description,
                    new MillisecondsValue(System.currentTimeMillis() - start).shortString()
            )
        );
        return result;
    }

    public static long inMills(Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        return System.currentTimeMillis() - start;
    }
}
