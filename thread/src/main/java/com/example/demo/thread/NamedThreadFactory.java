package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author where
 */
@Slf4j
public class NamedThreadFactory implements ThreadFactory {
    private final String name;
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    public NamedThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        log.info("{}", COUNTER.get());

        return new Thread(r, name + "-THREAD_POOL-" + COUNTER.getAndAdd(1));
    }
}
