package com.cn.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局错误页
 */
@RestController
@RequestMapping("/errors/*")
public class ErrorPageAction {

    @RequestMapping("error_404")
    public Object errorCode404(){
       HttpServletRequest request =
               ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
       HttpServletResponse response =
               ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getResponse();
       response.setStatus(HttpServletResponse.SC_NOT_FOUND);
       Map<String,Object> map = new HashMap();
       map.put("status",HttpServletResponse.SC_NOT_FOUND);
       map.put("content","url not found");
       map.put("referer",request.getHeader("Referer"));
       map.put("path",request.getRequestURL());
       return map;
    }
    @RequestMapping("error_500")
    public Object errorCode500(){
        HttpServletRequest request =
                ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response =
                ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getResponse();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        Map<String,Object> map = new HashMap();
        map.put("status",HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        map.put("content","server error");
        map.put("referer",request.getHeader("Referer"));
        map.put("path",request.getRequestURL());
        return map;
    }
}
