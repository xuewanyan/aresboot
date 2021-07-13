package com.cn.service;

import com.cn.annotation.Treat;
import com.cn.vo.Jsr3Message;

public interface IMessageService {
    public Jsr3Message echo(Jsr3Message message);
}
