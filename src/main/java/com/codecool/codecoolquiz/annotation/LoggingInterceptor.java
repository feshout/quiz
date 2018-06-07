package com.codecool.codecoolquiz.annotation;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class.getName());

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        logger.debug("LoggingInterceptor " + context.getMethod().getName());

        Object result = context.proceed();

        logger.debug("LoggingInterceptor " + context.getMethod().getName());

        return result;
    }
}
