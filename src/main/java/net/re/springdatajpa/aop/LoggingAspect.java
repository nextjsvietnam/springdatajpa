package net.re.springdatajpa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, class-name.method-name(args)
    @Before("execution(* net.re.springdatajpa.controller.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint){
        LOGGER.info("Method calls! " + joinPoint.getSignature().getName());
    }

    // return type, class-name.method-name(args)
    @Before("execution(* net.re.springdatajpa.controller.*.*(..))")
    public void logMethodExecuted(JoinPoint joinPoint){
        LOGGER.info("Method executed! " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* net.re.springdatajpa.controller.*.*(..))")
    public void logMethodCrash(JoinPoint joinPoint){
        LOGGER.info("Method has some issues " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* net.re.springdatajpa.controller.*.*(..))")
    public void logExecutionSuccess(JoinPoint joinPoint){
        LOGGER.info("Method executed successfully " + joinPoint.getSignature().getName());
    }
}
