package com.cn.nbcb.action;

import com.cn.nbcb.service.IMmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xy
 * @date 2021-8-26
 */
@RestController
@RequestMapping("mybatis/*")
public class MmpAction2 {

    @Autowired
    private IMmpService iMmpService;

    @PostMapping("mmp")
    public Object getMmpVo(){
        return iMmpService.list();
    }
}
