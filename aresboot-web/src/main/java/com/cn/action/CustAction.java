package com.cn.action;

import com.cn.event.CustEvent;
import com.cn.vo.CustInfo;
import com.cn.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xy
 * @date 2021-7-28
 */
@RequestMapping("cust/")
@RestController
public class CustAction {

    @Autowired
    private ApplicationEventPublisher publisher; // 事件发布类

    @PostMapping("/cust")
    public void sendCust(){
//        CustInfo custInfo = new CustInfo();
//        custInfo.idNo("2133312").name("阿斯顿").sex("女");
        this.publisher.publishEvent(new Message()); // 触发监听
        // 不影响后续事件进行把？？？
        System.out.println("事件监听后续进行=============================");
    }
}
