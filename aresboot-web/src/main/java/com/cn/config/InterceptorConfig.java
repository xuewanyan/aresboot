package com.cn.config;

import com.cn.interceptor.DefaultHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.getDefault()).addPathPatterns("/**");
    }

    @Bean
    public HandlerInterceptor getDefault(){
        return new DefaultHandlerInterceptor();
    }
}
