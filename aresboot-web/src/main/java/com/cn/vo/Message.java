package com.cn.vo;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data // 这就是lombok注解，这个注解使用的是最频繁的
@Accessors(fluent = true)
public class Message {
    private String title;
    private Date pubdate;
    private String content;
}
