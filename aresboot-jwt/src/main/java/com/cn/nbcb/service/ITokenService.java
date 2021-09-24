package com.cn.nbcb.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;

import javax.crypto.SecretKey;
import java.security.Security;
import java.util.Map;

/**
 * @author xy
 * @date 2021-9-22
 */
public interface ITokenService {

    /**
     * 获取当前JWT数据加密KEY
     * @return
     */
    public SecretKey generalKey();

    /**
     * 生成一个合法的token数据，
     * @param id    这个Token的唯一id(随意储存，本次可以考虑存储用户ID)
     * @param subject   所有附加的信息内容，本次直接接收了一个Map,但是最终存储的时候存放JSON
     * @return  返回一个有效的TOKEN数据字符串
     */
    public String creatToken(String id, Map<String ,Object> subject);

    /**
     * 是根据Token的字符串内容解析出其组成的信息（头信息与附件信息）
     * @param token 要解析的token完整数据
     * @return  Jws接口实例
     * @throws JwtException 如果Token失效或者结构错误
     */
    public Jws<Claims> parseToken(String token) throws JwtException;

    /**
     * 校验当前传递的token是否正确
     * @param token 要坚持的Token数据
     * @return  true表示合法，false表示无效
     */
    public boolean verifyToken(String token);

    /**
     * token存在有效时间的定义，所以一定要提供有Token刷新机制
     * @param token 原始的token数据
     * @return  新的token数据
     */
    public String refershToken(String token);
}
