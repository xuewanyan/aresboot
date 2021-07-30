package com.cn.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author xy
 * @date 2021-7-28
 */
@Data
@Accessors(fluent = true)
public class CustInfo {

    private String name;

    private String idNo;

    private String sex;
}
