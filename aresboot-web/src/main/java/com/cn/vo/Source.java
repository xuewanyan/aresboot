package com.cn.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties("muyan")
@Component
public class Source {
    private String mysql;
    private List<String> message;
    private Map<String,String> books;
}
