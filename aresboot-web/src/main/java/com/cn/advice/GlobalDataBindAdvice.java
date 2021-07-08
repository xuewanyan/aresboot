package com.cn.advice;

import com.cn.vo.ResponseBaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现全局数据绑定
 */
@ControllerAdvice
public class GlobalDataBindAdvice {

    /**
     * responseBaseVo
     */
    @Autowired
    private ResponseBaseVo responseBaseVo;


    @ModelAttribute(name = "bindModel")
    public Object dataBind(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg",this.responseBaseVo.getMsg());
        map.put("code",this.responseBaseVo.getCode());
        return map;
    }
}
