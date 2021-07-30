package com.cn.task;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 动态cron配置
 * @author xy
 * @date 2021-7-27
 */
@Component
@Data
public class DynamicCronExpression {

    /**
     * 默认表达式
     */
    private String cron = "/10 * * * * ?";
}
