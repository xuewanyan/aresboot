package com.cn.rsocket.server.handler;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.util.DefaultPayload;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * RSocket - 原始rsocket官方提供
 *
 * @author xy
 * @date 2021-8-6
 */
@Slf4j
public class MessageRSocketHandler implements RSocket {

    /**
     * 重新接收无响应方法
     *
     * @param payload
     * @return
     */
    @Override
    public Mono<Void> fireAndForget(Payload payload) {
        // 无响应记录，一般应用于日志记录
        // Payload表示所有的附加信息
        String message = payload.getDataUtf8();
        log.info("接收信息【】：{}", message);
        return Mono.empty();
    }

    /**
     * 有请求，有响应模式
     *
     * @param payload
     * @return
     */
    @Override
    public Mono<Payload> requestResponse(Payload payload) {
        String message = payload.getDataUtf8();
        log.info("【RequestAndResponse】接收请求数据：{}", message);
        return Mono.just(DefaultPayload.create("[ECHO]" + message));
    }


    /**
     * 处理流数据
     *
     * @param payload
     * @return
     */
    @Override
    public Flux<Payload> requestStream(Payload payload) {
        String message = payload.getDataUtf8();
        log.info("【RequestStream】接收请求数据：{}", message);
        return Flux.fromStream(message.chars() // 将接收到的字符串转换为int数据流
                .mapToObj(b -> Character.toUpperCase((char) b)) // 获取里面的每一个字符的编码，并且转大写
                .map(Object::toString) // 利用toString()方法将字符转为String
                .map(DefaultPayload::create)); // 创建Payload的附加数据
    }

    /**
     * 双向流
     *
     * @param payloads
     * @return
     */
    @Override
    public Flux<Payload> requestChannel(Publisher<Payload> payloads) {
        return Flux.from(payloads).map(Payload::getDataUtf8).map(msg -> {
                    log.info("[RequestChannel]接收请求数据：{}", msg);
                    return msg;
                }
        ).map(DefaultPayload::create);
    }
}
