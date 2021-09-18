package com.cn.nbcb.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xy
 * @date 2021-9-14
 */
@RestController
@RequestMapping("sec")
public class SecurityAction {

    @GetMapping("sec")
    public Object show(){
        return "wwww.xueyan.com";
    }
}
