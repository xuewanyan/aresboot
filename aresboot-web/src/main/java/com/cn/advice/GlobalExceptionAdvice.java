package com.cn.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 */

@ControllerAdvice
public class GlobalExceptionAdvice {

    /**
     *  实现所有的异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("message",e.getMessage());
        map.put("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        map.put("exception",e.getClass().getName());
        return map;
    }
}
