package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Where.LIU
 * @since 2022/4/19
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class ResizableCapacityLinkedBlockingQueueTests {
    @Test
    public void resize() {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolFactory.make("test", 2);

        int corePoolSize = threadPoolExecutor.getCorePoolSize();
        int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
        BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
        ResizableCapacityLinkedBlockingQueue<?> resize = (ResizableCapacityLinkedBlockingQueue<?>) queue;

        log.info("修改前 cor {} max {} queue {}", corePoolSize, maximumPoolSize, resize.getCapacity());

        threadPoolExecutor.setMaximumPoolSize(32);
        threadPoolExecutor.setCorePoolSize(32);
        resize.setCapacity(16);

        log.info("修改后 cor {} max {} queue {}", threadPoolExecutor.getCorePoolSize(), threadPoolExecutor.getMaximumPoolSize(), resize.getCapacity());
    }
}
