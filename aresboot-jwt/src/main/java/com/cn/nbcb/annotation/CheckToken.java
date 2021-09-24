package com.cn.nbcb.annotation;

import java.lang.annotation.*;

/**
 * @author xy
 * @date 2021-9-23
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckToken {
    /**
     * 用于方法上的注解，如果需要验证拦截token，则配置true
     * @return
     */
    public boolean required() default true;
}
