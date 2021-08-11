package com.cn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author xy
 * @date 2021-8-3
 */
@Configuration
public class CustAsyncPoolConfig implements WebMvcConfigurer { // 自定义的线程池


    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(10000);
        configurer.registerCallableInterceptors(this.getTimetor()); // 设置Callable拦截器
        configurer.setTaskExecutor(this.getTheadtor());
    }

    public ThreadPoolTaskExecutor getTheadtor(){
        ThreadPoolTaskExecutor executor= new ThreadPoolTaskExecutor();
        executor.setKeepAliveSeconds(200);
        executor.setMaxPoolSize(200);
        executor.setCorePoolSize(20); // 内核线程数量
        executor.setThreadNamePrefix("xy-pool-"); // 别名
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); // 拒绝策略
        executor.initialize();
        return executor;
    }

    @Bean
    public TimeoutCallableProcessingInterceptor getTimetor(){
        return new TimeoutCallableProcessingInterceptor();
    }
}
