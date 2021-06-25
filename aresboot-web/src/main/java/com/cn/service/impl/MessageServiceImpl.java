package com.cn.service.impl;

import com.cn.service.IMessageService;

public class MessageServiceImpl implements IMessageService {
    @Override
    public String echo(String msg) {
        return "ECHO"+ msg;
    }
}
