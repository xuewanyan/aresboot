package com.cn.action;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * ResponseAction
 */
@RestController
@RequestMapping("/back/*")
@Slf4j
public class ResponseAction {

    @PostMapping("data")
    public Object code(Model model){
        Map<String,Object> map = (Map<String, Object>) model.asMap().get("bindModel");
        log.info("==================map:[{}]",map);
        return map;
    }
}
