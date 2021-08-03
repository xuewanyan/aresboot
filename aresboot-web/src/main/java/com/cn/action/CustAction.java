package com.cn.action;

import com.cn.event.CustEvent;
import com.cn.vo.CustInfo;
import com.cn.vo.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xy
 * @date 2021-7-28
 */
@RequestMapping("cust/")
@RestController
@Slf4j
public class CustAction {

    @Autowired
    private ApplicationEventPublisher publisher; // 事件发布类

    @PostMapping("/cust")
    public Object sendCust(@RequestBody CustInfo custInfo){
        custInfo.idNo("2133312").name("阿斯顿").sex("女");
        Map<String,String> map = new HashMap<>();
        map.put("name","1");
        this.publisher.publishEvent(custInfo); // 触发监听
        log.info("异步返回===================");
        return map;
    }
}
