package com.cn.vo;


import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data // 这就是lombok注解，这个注解使用的是最频繁的
@XmlRootElement // 培配置了xml根元素
public class Message {
    @XmlElement
    private String title;
    @XmlElement
    private Date pubdate;
    @XmlElement
    private String content;
}
