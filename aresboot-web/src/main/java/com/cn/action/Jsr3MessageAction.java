package com.cn.action;

import com.cn.service.IMessageService;
import com.cn.vo.Jsr3Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController // 直接基于Rest架构进行处理，省略了@ResponseBody注解
@RequestMapping("jsr3/*")
public class Jsr3MessageAction extends BaseAction{ // 控制层实现类

    /**
     * 日志工具
     */
    private static final Logger logger = LoggerFactory.getLogger(Jsr3MessageAction.class);

    @Autowired
    private IMessageService messageService;


    @PostMapping(value = "/jsr",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object echo(@RequestBody @Valid Jsr3Message message){
        Jsr3Message message2 =  messageService.echo(message);
        message.setTitle("[getTitle]"+message2.getTitle());
        message.setInfo("[getInfo]"+message2.getInfo());
        return message;
    }
}
