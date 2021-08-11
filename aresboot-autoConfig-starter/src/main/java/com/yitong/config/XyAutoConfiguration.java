package com.yitong.config;

import com.yitong.regist.DefaultRegistBean;
import com.yitong.selector.DefaultSelectorImport;
import com.yitong.vo.Detp;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xy
 * @date 2021-8-9
 */
@Configuration
//@EnableConfigurationProperties(Detp.class)
//@Import(DefaultSelectorImport.class)
@Import(DefaultRegistBean.class)
public class XyAutoConfiguration {

}
