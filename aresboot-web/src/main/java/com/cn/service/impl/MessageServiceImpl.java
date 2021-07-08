package com.cn.service.impl;

import com.cn.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageServiceImpl implements IMessageService {
    @Override
    public String echo(String msg) {
        log.info("ECHO========================="+ msg );
        return "ECHO"+ msg;
    }
}
