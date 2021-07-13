package com.cn.service.impl;

import com.cn.annotation.Treat;
import com.cn.service.IMessageService;
import com.cn.vo.Jsr3Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageServiceImpl implements IMessageService {
    @Override
    public Jsr3Message echo(@Treat Jsr3Message msg) {
        log.info("ECHO========================="+ msg);
        msg.setInfo("00000  ");
        msg.setTitle("44444  ");
        return msg;
    }
}
