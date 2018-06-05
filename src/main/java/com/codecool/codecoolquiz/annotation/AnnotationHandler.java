package com.codecool.codecoolquiz.annotation;

import com.codecool.codecoolquiz.log.Log;
import javassist.NotFoundException;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AnnotationHandler {

    @Pointcut("@annotation(LogAnnotation)")
    public void logAnnotation(LogAnnotation LogAnnotation){}

    @Pointcut("@annotation(ResourceNotFound)")
    public void resourceNotFoundAnnotation(ResourceNotFound ResourceNotFound){}

    @Pointcut("@annotation(InternalServerError)")
    public void internalServerErrorAnnotation(InternalServerError InternalServerError){}

    @Pointcut("execution(* *(..))")
    public void atExecution(){}

    @Around("logAnnotation(LogAnnotation) && atExecution()")
    public Object handleLog(ProceedingJoinPoint joinPoint, LogAnnotation LogAnnotation) throws Throwable {
        Log log = new Log();
        log.logEvent(joinPoint.getClass(), LogAnnotation.message());
        return joinPoint.proceed();
    }

    @Around("resourceNotFoundAnnotation(ResourceNotFound) && atExecution()")
    public Object handleNotFound(ProceedingJoinPoint joinPoint,
                                 ResourceNotFound ResourceNotFound) throws Throwable {
        Object obj = joinPoint.proceed();
        if (obj == null)
            throw new NotFoundException("Resource not found");

        return joinPoint.proceed();
    }

    @Around("internalServerErrorAnnotation(InternalServerError) && atExecution()")
        public Object handleInternalServerError(ProceedingJoinPoint joinPoint,
                                                InternalServerError InternalServerError) throws Throwable{
        throw new InternalException("Server error.");
    }
}
