package com.cn.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalDataPreparAdvice {

    @InitBinder("company")
    public void company(WebDataBinder binder){
        binder.setFieldDefaultPrefix("company.");
    }

    @InitBinder("dept")
    public void dept(WebDataBinder binder){
        binder.setFieldDefaultPrefix("dept.");
    }
}
