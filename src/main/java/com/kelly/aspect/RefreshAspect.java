package com.kelly.aspect;

import com.kelly.async.RefreshProcesser;
import com.kelly.async.RefreshTask;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(0)
@Component
@Aspect
public class RefreshAspect {
    private static final Logger logger = LoggerFactory.getLogger(RefreshAspect.class);

    @Autowired
    private RefreshProcesser refreshProcesser;

    @Pointcut("execution(* com.kelly.service.impl.RequestServiceImpl.*(..))")
    public void pointcut(){ }

    @Around("pointcut()")
    public Object test1(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        try {
            result = joinPoint.proceed();
            List<Integer> list = RefreshProcesser.refreshItems.get();
            refreshProcesser.addRefreshTask(new RefreshTask(list.get(0)));
        }finally {
            RefreshProcesser.refreshItems.remove();
        }
        return result;
    }
}
