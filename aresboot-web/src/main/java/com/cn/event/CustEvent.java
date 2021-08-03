package com.cn.event;

import com.cn.vo.CustInfo;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.util.concurrent.TimeUnit;

/**
 * 自定义事件处理,使用注解后这个包装类可以省略
 * @author xy
 * @date 2021-7-28
 */
@Slf4j
@Getter
public class CustEvent extends ApplicationEvent {

    /**
     * 事件需要处理的数据
     */
    private CustInfo custInfo;


    /**
     * 产生事件后，保存具体的数据
     * @param source
     * @param custInfo
     */
    public CustEvent(Object source, CustInfo custInfo) {
        super(source);
        this.custInfo = custInfo;
    }

    public void detell(){
        log.info("处理监听事件数据{}",this.custInfo);
    }
}
