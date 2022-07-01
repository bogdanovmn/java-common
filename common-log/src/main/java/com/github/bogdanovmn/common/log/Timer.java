package com.github.bogdanovmn.common.log;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Timer {
    private final long startedAt;

    public static Timer start() {
        return new Timer(
            System.currentTimeMillis()
        );
    }

    public long durationInMills() {
        return System.currentTimeMillis() - startedAt;
    }
}
