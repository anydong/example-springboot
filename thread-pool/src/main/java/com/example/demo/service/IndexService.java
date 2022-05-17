package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Where.LIU
 * @since 2022/5/16
 */
@Component
@Slf4j
public class IndexService {
    @Async
    public void index() {
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException exception) {
            log.error("", exception);
        }

        log.info("IndexService - index {}", System.currentTimeMillis());
    }
}
