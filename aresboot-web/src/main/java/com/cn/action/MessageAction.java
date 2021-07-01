package com.cn.action;

import com.cn.service.IMessageService;
import com.cn.vo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController // 直接基于Rest架构进行处理，省略了@ResponseBody注解
@RequestMapping("message")
public class MessageAction extends BaseAction{ // 控制层实现类

    /**
     * 日志工具
     */
    private static final Logger logger = LoggerFactory.getLogger(MessageAction.class);

    @Resource(name = "messageService")
    private IMessageService messageService;

    @PostMapping(value = "/echo")
    public Object echo(@RequestBody Message message){
        message.setTitle("[ECHO]"+message.getTitle());
        message.setContent("[ECHO]"+message.getContent());
        return message;
    }
}
