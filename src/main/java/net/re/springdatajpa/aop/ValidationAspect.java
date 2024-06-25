package net.re.springdatajpa.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* net.re.springdatajpa.controller.JobController.findOne(..)) && args(jobId)")
    public Object validateAndUpdate(ProceedingJoinPoint joinPoint, int jobId) throws Throwable {
        if(jobId < 0){
            jobId = -jobId;
        }

        return joinPoint.proceed(new Object[]{jobId});
    }
}
