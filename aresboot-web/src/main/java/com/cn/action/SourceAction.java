package com.cn.action;

import com.cn.vo.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * xueyan
 */
@RestController
@RequestMapping("/source/*")
public class SourceAction {

    @Value("${source.mysql}")
    private String mysql;

    @Value("${source.message}")
    private String mag;

    @Value("#{${source.infos}}")
    private Map<String,String> infos;

    @Autowired
    private Source source;


    @GetMapping("action")
    public Object getSource(){
        Map map = new HashMap();
        map.put("mysql",this.mysql);
        map.put("message",this.mag);
        map.put("infos",this.infos);
        map.put("path",System.getProperty("java.class.path"));
        return map;
    }

    @GetMapping("show")
    public Object show(){
        return this.source;
    }
}
