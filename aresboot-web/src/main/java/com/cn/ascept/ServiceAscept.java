package com.cn.ascept;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * aop
 */
@Component
@Aspect
@Slf4j
public class ServiceAscept {

    @Around("execution(* com.cn..service..*.*(..))")
    public Object aroundInvoke(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("[bedofe======]开始,{}", Arrays.toString(joinPoint.getArgs()));
        Object obj = joinPoint.proceed(joinPoint.getArgs());
        log.info("[obj======]结束,{}", obj);
        return obj;
    }
}
