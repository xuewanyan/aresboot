package com.yitong.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xy
 * @date 2021-8-9
 */
@Data
@ConfigurationProperties(prefix = "xueyan.yookt.dept")
public class Detp {
    private Long deptno;
    private String dname;
    private String dloc;
}
