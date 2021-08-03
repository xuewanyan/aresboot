package com.cn.config;

import com.cn.event.CustEvent;
import com.cn.vo.CustInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Future;

/**
 * 事件今天配置类
 * @author xy
 * @date 2021-7-29
 */
@Configuration
@Slf4j
@EnableAsync
public class ObjListenerConfig {

    @Async
    @EventListener
    public void addListener(CustInfo event){
       log.info("当前线程名称[{}]",Thread.currentThread().getName());
    }
}
