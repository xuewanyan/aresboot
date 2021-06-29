package com.cn.lombok;

import lombok.SneakyThrows;

/**
 * 异常控制
 */
public class MessageHandle {

    @SneakyThrows
    public void test(){
        int ai = 0;
        if(ai == 0){
            throw new RuntimeException("ss");
        }
    }
}
