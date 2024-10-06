package com.kamal.springBootRest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //returnTye className.methodName(args)
    @Before("execution(* com.kamal.springBootRest.service.JobService.*(..))")
    public void logMethodCall(){
        LOGGER.info("Method Called..");
    }

    @Before("execution(* com.kamal.springBootRest.service.JobService.getJob(..)) ||" +
            "execution(* com.kamal.springBootRest.service.JobService.getAllJobs(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed.. --> " + jp.getSignature().getName());
    }


    @After("execution(* com.kamal.springBootRest.service.JobService.getJob(..)) ||" +
            "execution(* com.kamal.springBootRest.service.JobService.getAllJobs(..))")
    public void logMethodExecutedAfter(JoinPoint jp){
        LOGGER.info("Method Executed After.. --> " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.kamal.springBootRest.service.JobService.getJob(..)) ||" +
            "execution(* com.kamal.springBootRest.service.JobService.getAllJobs(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method Executed Crashed.. --> " + jp.getSignature().getName());
    }


    @AfterReturning("execution(* com.kamal.springBootRest.service.JobService.getJob(..)) ||" +
            "execution(* com.kamal.springBootRest.service.JobService.getAllJobs(..))")
    public void logMethodExecutedSuccess(JoinPoint jp){
        LOGGER.info("Method Executed Success.. --> " + jp.getSignature().getName());
    }




}
