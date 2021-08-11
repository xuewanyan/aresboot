package com.cn.config;
import com.cn.vo.CustInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.TimeUnit;

/**
 * 事件今天配置类
 * @author xy
 * @date 2021-7-29
 */
@Configuration
@Slf4j
public class ObjListenerConfig {

    @Async
    public void addListener(CustInfo event){

        log.info("进入异步线程=====================");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("当前线程名称[{}]",Thread.currentThread().getName());
    }

}
