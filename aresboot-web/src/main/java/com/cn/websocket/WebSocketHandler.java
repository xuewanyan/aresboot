package com.cn.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.UUID;

/**
 * 服务端
 * websocket处理类
 * @author xy
 * @date 2021-8-3
 */
@ServerEndpoint("/websocket/{token}") // 需要给客户端提供一个操作终端
@Component
@Slf4j
public class WebSocketHandler {

    @OnOpen
    public void openHandler(Session session,@PathParam("token") String token){
        if(!StringUtils.hasLength(token)){
            this.sendMessage(session,"[ERROE] 客户端Token错误，连接失败！");
        }
        log.info("客户端创建连接，Session={}",session.getId());
        this.sendMessage(session, UUID.randomUUID().toString());
    }

    @OnClose
    public void closeHandler(Session session){
        log.info("客户端断开Socket连接，SessionId={}",session.getId());
    }

    @OnError
    public void errorHandler(Session session,Throwable throwable){
        log.info("程序出现了错误，Session = {}",session.getId());
    }

    @OnMessage
    public void messageHandler(Session session,String message){
        log.info("[]用户发送请求，内容为【{}】",session.getId(),message);
        this.sendMessage(session,"[ECHO] "+message);
    }

    /**
     * 发送信息
     * @param session
     * @param message
     */
    public void sendMessage(Session session,String message){
        if(null != session){
            synchronized (session){
                try {
                    session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                   log.error("send is error:{}",e.getMessage());
                }
            }
        }
    }
}
