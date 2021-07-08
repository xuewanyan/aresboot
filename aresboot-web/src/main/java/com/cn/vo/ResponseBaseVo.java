package com.cn.vo;

import lombok.*;

/**
 * 公共返回
 */
@Data
public class ResponseBaseVo {
    /**
     * msg
     */
    private String msg;
    /**
     * code
     */
    private String code;

    public ResponseBaseVo setCode(String code) {
        this.code = code;
        return this;
    }

    public ResponseBaseVo setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
