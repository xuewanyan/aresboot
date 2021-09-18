package com.cn.nbcb.annotation;

import java.lang.annotation.*;

/**
 * @author xy
 * @date 2021-9-2
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheAnntation {
    String name() default "";
}
