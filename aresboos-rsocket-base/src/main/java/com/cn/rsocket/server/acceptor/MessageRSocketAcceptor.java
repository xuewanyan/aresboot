package com.cn.rsocket.server.acceptor;

import com.cn.rsocket.server.handler.MessageRSocketHandler;
import io.rsocket.ConnectionSetupPayload;
import io.rsocket.RSocket;
import io.rsocket.SocketAcceptor;
import reactor.core.publisher.Mono;

/**
 * @author xy
 * @date 2021-8-6
 */
public class MessageRSocketAcceptor implements SocketAcceptor {

    /**
     * 实现RSocket连接处理
     * @param setup
     * @param sendingSocket
     * @return
     */
    @Override
    public Mono<RSocket> accept(ConnectionSetupPayload setup, RSocket sendingSocket) {
        return Mono.just(new MessageRSocketHandler());
    }
}
