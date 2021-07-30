package com.cn.config;

import com.cn.event.CustEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * 事件今天配置类
 * @author xy
 * @date 2021-7-29
 */
@Configuration
@Slf4j
public class ObjListenerConfig {

    @EventListener
    private void addListener(CustEvent event){
        log.info("监听的事件========{}",event);
    }
}
