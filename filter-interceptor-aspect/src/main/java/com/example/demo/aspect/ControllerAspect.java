package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class ControllerAspect {
    private static final String POINT_CUT = "execution(public * com.example.demo.controller..*.*(..))";

    @Pointcut(value = POINT_CUT)
    public void pointcut() {
        log.info("aaaa");
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("step 1: {}", pjp);
        Object result = pjp.proceed();
        log.info("step 5: {}", result);
        return result;
    }

    /**
     * 前置通知（Before advice）：在一个连接点之前执行的通知
     */
    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint) {
        log.info("step 2: {}", joinPoint);
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (Objects.nonNull(servletRequestAttributes)) {
            HttpServletRequest request = servletRequestAttributes.getRequest();
        }
    }


    /**
     * 后置返回通知（After returning advice）：在一个连接点正常完成后执行的通知
     */
    @AfterReturning(pointcut = "pointcut()")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("step 3: {}", joinPoint);
    }

    /**
     * 后置异常通知（After throwing advice）：在一个方法抛出一个异常退出时执行的通知
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        log.info("step 3: {}, throwable: {}", joinPoint, throwable);
    }

    /**
     * 后置（最终）通知（After(finally) advice）：在一个连接点退出时（不管是正常还是异常返回）执行的通知
     */
    @After(value = "pointcut()")
    public void after(JoinPoint joinPoint) {
        log.info("step 4: {}", joinPoint);
    }
}
