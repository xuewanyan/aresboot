package com.cn.nbcb.ascept;

import com.cn.nbcb.annotation.CacheAnntation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author xy
 * @date 2021-9-2
 */
@Aspect
@Slf4j
@Component
public class CacheResid {

    @Pointcut("@annotation(com.cn.nbcb.annotation.CacheAnntation)")
    private void pointCut(){

    }

    @Around(value = "pointCut() && @annotation(cacheAnntation)")
    public void aroundCut(ProceedingJoinPoint joinPoint, CacheAnntation cacheAnntation){
        log.info("============={}",joinPoint);
        String name = cacheAnntation.name();
        log.info("==============name:{}",name);
    }
}
