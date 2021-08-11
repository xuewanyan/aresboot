package com.yitong.config;

import com.yitong.vo.Detp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xy
 * @date 2021-8-10
 */
@Configuration
public class BeanConfig {

    @Bean("dpi")
    public Detp getBean(){
        Detp detp = new Detp();
        detp.setDname("阿斯顿");
        return detp;
    }
}
