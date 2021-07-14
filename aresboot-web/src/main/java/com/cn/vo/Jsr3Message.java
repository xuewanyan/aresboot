package com.cn.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 验证validate
 */
@Data
public class Jsr3Message {

    @NotNull(message = "{message.title.notblank.error}")
    private String info;

    @NotNull
    private String title;
}
