package com.example.demo.filter;

import com.example.demo.util.HttpRequestWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Where.LIU
 * @since 2022/5/17
 */
@WebFilter
@Slf4j
public class BasicFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper((HttpServletRequest) servletRequest);
        filterChain.doFilter(httpRequestWrapper, servletResponse);
    }
}
