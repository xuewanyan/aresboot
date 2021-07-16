package com.cn.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 自定义MDC拦截器
 */
@Slf4j
public class MDCInterceptor implements HandlerInterceptor {

    private String REQUEST_ID = "requestId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String forward = request.getHeader("X-Forwarded-For");
        String clientIp = request.getRemoteAddr();
        String uuid = UUID.randomUUID().toString().substring(0,12);
        log.info("MDC操作记录开始：requestId = {}", uuid);
        log.info("forward = {},clientIp={},requestId={}", forward, clientIp, uuid);
        MDC.put(this.REQUEST_ID, uuid);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String uuid = MDC.get(this.REQUEST_ID);
        log.info("MDC操作记录结束，request={}", uuid);
        MDC.remove(this.REQUEST_ID);
    }
}