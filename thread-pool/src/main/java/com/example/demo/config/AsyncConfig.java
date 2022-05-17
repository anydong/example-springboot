package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author Where.LIU
 * @since 2022/5/16
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    private static final int CORE_SIZE = Runtime.getRuntime().availableProcessors();

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setQueueCapacity(CORE_SIZE);
        executor.setMaxPoolSize(CORE_SIZE * 2);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setQueueCapacity(100);
        executor.initialize();
        return executor;
    }
}
