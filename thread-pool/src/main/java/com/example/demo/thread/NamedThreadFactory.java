package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author where
 */
@Slf4j
public class NamedThreadFactory implements ThreadFactory {
    private final String name;
    private final AtomicInteger counter;

    public NamedThreadFactory(String name) {
        this.name = name;
        this.counter = new AtomicInteger(0);
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "THREAD-POOL_" + name + "_" + counter.addAndGet(1));
    }
}
