package com.cn.xy;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author xy
 * @date 2021-8-19
 */
@Data
@Component
public class Watch {

    private long startTime;

    private long stopTime;

    public void start(){
        this.startTime = System.nanoTime();
    }

    public void stop(){
        this.stopTime = System.nanoTime();
    }

    public long getAllTime(){
        return this.stopTime - this.startTime;
    }

}
