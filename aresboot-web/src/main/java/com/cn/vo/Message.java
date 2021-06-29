package com.cn.vo;


import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data // 这就是lombok注解，这个注解使用的是最频繁的
@Builder // 建造者模式
public class Message {
    private String title;
    private Date pubdate;
    private String content;
}
