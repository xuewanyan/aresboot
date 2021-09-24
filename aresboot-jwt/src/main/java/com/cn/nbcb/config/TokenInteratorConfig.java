package com.cn.nbcb.config;

import com.cn.nbcb.interator.TokenInterator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xy
 * @date 2021-9-23
 */
@Configuration
public class TokenInteratorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.getJWTConfigProperties()).addPathPatterns("/**");
    }

    @Bean
    public HandlerInterceptor getJWTConfigProperties(){
        return new TokenInterator();
    }
}
