package com.cn.common.validation.annotation.handler;

import com.cn.common.validation.annotation.RegexValidation;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 注解处理类
 */
@Slf4j
public class HandlerRegexValidation implements ConstraintValidator<RegexValidation,Object> {

    private String regex;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(null == value){
            return false;
        }
        return value.toString().matches(this.regex);
    }

    @Override
    public void initialize(RegexValidation constraintAnnotation) {
        this.regex = constraintAnnotation.parant(); // 获得正则
        log.info("当前正则[{}]",this.regex);
    }
}
