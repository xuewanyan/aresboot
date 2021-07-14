package com.cn.vo;

import com.cn.common.validation.annotation.RegexValidation;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 自定义正则验证类
 */
@Data
public class Parant {

    @NotNull(message = "title不能为空")
    private String title;

    /**
     * xueyan-2021
     */
    @RegexValidation(parant = "[a-zA-Z]{1,6}-\\d{1,4}",message = "email格式不正确")
    @NotNull(message = "email不能为空")
    private String email;
}
