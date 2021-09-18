package com.cn.nbcb.action;

import com.cn.nbcb.service.TestYanyiService;
import com.cn.nbcb.vo.AnotVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xy
 * @date 2021-9-2
 */
@RestController
@RequestMapping("annot/*")
@Slf4j
public class AnnotationAction {

    @Autowired
    private TestYanyiService testYanyiService;

    @PostMapping("/annot")
    public Object getAnnot(@RequestBody AnotVo vo){
        int test = testYanyiService.test(10);
        log.info("test==========={}",test);
        log.info("vo==={}",vo);
        AnotVo vo1 = new AnotVo();
        vo1.setName("3");
        return vo1;
    }
}
