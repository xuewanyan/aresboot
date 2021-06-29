package com.cn.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(prefix = "xueyan")
public class Empl {
    private String xueyanName;
    private Integer xueyanId;
}
