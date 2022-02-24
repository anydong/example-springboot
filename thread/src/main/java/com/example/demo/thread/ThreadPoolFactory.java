package com.example.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author where
 */
public class ThreadPoolFactory {
    private static final Integer KEEP_ALIVE_TIME_DEFAULT = 1000;
    private static final TimeUnit TIME_UNIT_DEFAULT = TimeUnit.MILLISECONDS;

    /**
     * 新建线程池
     *
     * @param namePrefix      线程名称前缀
     * @param corePoolSize    核心线程池大小
     * @param maximumPoolSize 最大线程池大小
     * @param workQueueSize   等待队列大小
     * @return 线程池
     */
    public static ThreadPoolExecutor make(String namePrefix, int corePoolSize, int maximumPoolSize, int workQueueSize) {
        return new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                KEEP_ALIVE_TIME_DEFAULT,
                TIME_UNIT_DEFAULT,
                new ArrayBlockingQueue<>(workQueueSize),
                new NamedThreadFactory(namePrefix));
    }

    /**
     * 新建线程池
     *
     * @param namePrefix      线程名称前缀
     * @param corePoolSize    核心线程池大小
     * @param maximumPoolSize 最大线程池大小
     * @return 线程池
     */
    public static ThreadPoolExecutor make(String namePrefix, int corePoolSize, int maximumPoolSize) {

        return new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                KEEP_ALIVE_TIME_DEFAULT,
                TIME_UNIT_DEFAULT,
                new LinkedBlockingQueue<>(),
                new NamedThreadFactory(namePrefix));
    }

    /**
     * 新建线程池
     *
     * @param namePrefix 线程名称前缀
     * @return 线程池
     */
    public static ThreadPoolExecutor make(String namePrefix) {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maximumPoolSize = corePoolSize * 2;
        return new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                KEEP_ALIVE_TIME_DEFAULT,
                TIME_UNIT_DEFAULT,
                new LinkedBlockingQueue<>(),
                new NamedThreadFactory(namePrefix));
    }
}
