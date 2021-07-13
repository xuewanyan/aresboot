package com.cn.annotation;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Component
@Target({ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Treat {
}
