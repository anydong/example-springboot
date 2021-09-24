package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * https://juejin.cn/post/6844904121883951117
 * https://docs.spring.io/spring-framework/docs/4.3.15.RELEASE/spring-framework-reference/html/aop.html
 */
@Aspect
@Component
@Slf4j
public class LogicAspect {
    private static final String POINT_CUT = "execution(public * com.example.demo.logic..*.*(..))";

    @Pointcut(value = POINT_CUT)
    public void pointcut() {
    }

    /**
     * 环绕通知（Around advice）：环绕一个连接点的通知
     */
    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start();
        log.info("around proceedingJoinPoint: {}", proceedingJoinPoint);
        Object result = proceedingJoinPoint.proceed();
        sw.stop();
        log.info("process cost time {}: {}", proceedingJoinPoint.getTarget().toString(), sw.getTotalTimeMillis());
        return result;
    }
}
