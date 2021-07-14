package com.cn.common.validation.annotation;

import com.cn.common.validation.annotation.handler.HandlerRegexValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义正则注解
 */
@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = HandlerRegexValidation.class)
public @interface RegexValidation {

    String message() default "自定义注解报错了";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String parant(); // 自定义正则注解
}
