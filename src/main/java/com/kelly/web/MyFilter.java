package com.kelly.web;

import com.kelly.service.impl.RequestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class MyFilter implements Filter{
    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long tid = Thread.currentThread().getId();
        logger.info(Thread.currentThread().getName());
        logger.info(Long.valueOf(tid).toString());
//        Thread.currentThread().setName(UUID.randomUUID().toString());
        chain.doFilter(request,response);
        RequestServiceImpl.localMap.remove();
    }

    @Override
    public void destroy() {

    }
}
