package com.example.demo.lifecycle.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Bean 生命周期
 *
 * @author where
 */
@Component
@Slf4j
public class LifecycleBean implements InitializingBean, DisposableBean {
    /**
     * step 1
     */
    public LifecycleBean() {
        log.info("construct");
    }

    /**
     * step 2
     */
    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct");
    }

    /**
     * step 3
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet");
    }

    /**
     * step 4
     */
    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy");
    }

    /**
     * step 5
     */
    @Override
    public void destroy() throws Exception {
        log.info("destroy");
    }
}
