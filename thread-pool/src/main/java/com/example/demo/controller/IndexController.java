package com.example.demo.controller;

import com.example.demo.service.IndexService;
import com.example.demo.thread.ThreadPoolFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author where
 */
@Slf4j
@RestController
@RequestMapping
public class IndexController {
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = ThreadPoolFactory.make("HELLO");
    private final IndexService indexService;

    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping(value = "/")
    public void index() {
        for (int i = 0; i <= 20; i++) {
            THREAD_POOL_EXECUTOR.submit(getCallable());
            THREAD_POOL_EXECUTOR.submit(getRunnable());
        }

        log.info(THREAD_POOL_EXECUTOR.toString());
    }

    @GetMapping(value = "/async")
    public String async() {
        indexService.index();
        return String.valueOf(System.currentTimeMillis());
    }


    private Callable<String> getCallable() {
        return () -> {
            String name = Thread.currentThread().getName();
            StopWatch stopWatch = new StopWatch(name);
            stopWatch.start();
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stopWatch.stop();
            log.info("callable {}", name);
            return name;
        };
    }

    private Runnable getRunnable() {
        return () -> {
            String name = Thread.currentThread().getName();
            log.info("runnable {}", name);
        };
    }
}
