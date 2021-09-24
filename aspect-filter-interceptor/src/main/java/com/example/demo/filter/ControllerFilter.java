package com.example.demo.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@Order(1)
@WebFilter(filterName = "controllerFilter", urlPatterns = "/")
public class ControllerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.info("controllerFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("controllerFilter doFilter");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        log.info("controllerFilter destroy");
    }
}
