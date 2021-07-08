package com.cn.config;

import com.cn.vo.ResponseBaseVo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 返回配置类
 */
@Configuration
public class ResponseConfig {

    /**
     * 自定义返回response
     * @return
     */
    @Bean
    public ResponseBaseVo getResponse(){
        ResponseBaseVo responseBaseVo = new ResponseBaseVo();
        responseBaseVo.setCode("000000").setMsg("交易成功");
        return responseBaseVo;
    }
}
