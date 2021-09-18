package com.cn.config;

import com.cn.filter.MessageFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;


/**
 *
 */
@Configuration
@Slf4j
public class FilterConfig {

    @Bean
    public FilterRegistrationBean getMessageBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(this.getMessageFilter());
        filterRegistrationBean.setName("Mesgas");
        filterRegistrationBean.addUrlPatterns("/message/*");
        filterRegistrationBean.setOrder(5); // 可以设置过滤器的执行顺序
        log.info("=============================2");
        return filterRegistrationBean;
    }

    @Bean
    public Filter getMessageFilter(){
        log.info("=============================3");
        return new MessageFilter();
    }
}
