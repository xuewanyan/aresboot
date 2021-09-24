package com.cn.nbcb.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 * @author xy
 * @date 2021-9-23
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public Object exception(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("message",e.getMessage());
        map.put("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        map.put("exception",e.getClass().getName());
        return map;
    }
}
