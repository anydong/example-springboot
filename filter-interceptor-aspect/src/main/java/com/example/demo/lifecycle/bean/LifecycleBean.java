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
    public LifecycleBean() {
        log.info("construct");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy");
    }

    @Override
    public void destroy() throws Exception {
        log.info("destroy");
    }
}
