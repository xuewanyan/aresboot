package com.yitong.api;

import com.yitong.config.BeanConfig;
import com.yitong.config.XyAutoConfiguration;
import com.yitong.vo.Detp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xy
 * @date 2021-8-10
 */
@RestController
@RequestMapping("/dept/*")
@Slf4j
public class DeptAction {

    @Autowired
    private Detp detp;

    @PostMapping("/dept")
    public void dept(){
       log.info("==========" + this.detp);
        System.out.println(this);
    }
}
