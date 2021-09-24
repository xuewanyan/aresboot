package com.cn.nbcb.interator;

import com.cn.nbcb.annotation.CheckToken;
import com.cn.nbcb.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandleInfo;
import java.lang.reflect.Method;

/**
 * @author xy
 * @date 2021-9-23
 */
public class TokenInterator implements HandlerInterceptor {

    @Autowired
    private ITokenService iTokenService;

    /**
     * 前置拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){ // 不处理拦截
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod(); // 获取当前要执行action方法反射对象
        if(method.isAnnotationPresent(CheckToken.class)){
            CheckToken checkToken = method.getAnnotation(CheckToken.class);
            if(checkToken.required()){
                String token = this.getToken(request);
                if(!this.iTokenService.verifyToken(token)){
                    // 这里留个低，新增全局异常处理，待会加
                    throw new RuntimeException("token无效！！！");
                }
            }
        }
        return true;
    }

    /**
     * 获取token
     * @param request
     * @return
     */
    private String getToken(HttpServletRequest request){
        // 通过参数获取token，如果没有则通过头部获取token
        String token = request.getParameter("token");
        if(!StringUtils.hasText(token)){
            token = request.getHeader("token");
        }
        return token;
    }
}
