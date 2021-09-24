package com.cn.nbcb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xy
 * @date 2021-9-22
 */
@Data
@Component
@ConfigurationProperties(prefix = "nbcb.config.jwt")
public class JWTConfigProperties {

    private String sign;

    private String issure;

    private String secret;

    private long expire;
}
