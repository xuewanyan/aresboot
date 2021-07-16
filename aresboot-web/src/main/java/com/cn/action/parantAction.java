package com.cn.action;

import com.cn.vo.Parant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("action/*")
@RestController
@Slf4j
public class parantAction {

    @PostMapping("parant")
    public void action(@RequestBody Parant parant){
        log.trace("请求参数【{}】",parant);
        log.debug("请求参数【{}】",parant);
        log.info("请求参数【{}】",parant);
        log.warn("请求参数【{}】",parant);
        log.error("请求参数【{}】",parant);
    }
}
