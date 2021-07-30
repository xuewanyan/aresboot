package com.cn.event.listener;

import com.cn.event.CustEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听
 * @author xy
 * @date 2021-7-28
 */
@Component
@Slf4j
public class CustListener implements ApplicationListener<CustEvent> {

    /**
     * 事件处理
     * @param event
     */
    @Override
    public void onApplicationEvent(CustEvent event) {
        log.info("事件处理：{}",event);
        event.detell(); // 自定义事件处理
    }
}
