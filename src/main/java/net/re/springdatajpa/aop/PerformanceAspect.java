package net.re.springdatajpa.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Aspect
public class PerformanceAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("execution(* net.re.springdatajpa.controller.*.*(..))")
    public Object monitorTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object obj = joinPoint.proceed();

        long end = System.currentTimeMillis();

        LOGGER.info("Time taken " + (end - start) + "ms");

        return obj;
    }
}
