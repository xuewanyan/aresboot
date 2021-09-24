package com.cn.nbcb.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cn.nbcb.config.JWTConfigProperties;
import com.cn.nbcb.service.ITokenService;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xy
 * @date 2021-9-22
 */
@Service
@Slf4j
public class TokenServiceImpl implements ITokenService {
    /**
     * jwt相关配置
     */
    @Autowired
    private JWTConfigProperties jwtConfigProperties;

    /**
     * Groovy的三目表达式
     */
    @Value("${spring.application.name?:ares-boot-xy}")
    private String applicationName;

    /**
     * 签名算法
     */
    private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    @Override
    public SecretKey generalKey() { // 获取加密key
        byte [] oldByte = this.jwtConfigProperties.getSecret().getBytes();
        log.info("加密前的数据{}",oldByte);
        byte [] bytes = Base64.decodeBase64(Base64.encodeBase64(oldByte));
        log.info("加密后的数据{}",bytes);
        SecretKey secretKey = new SecretKeySpec(bytes,0,bytes.length,"AES");
        return secretKey;
    }

    @Override
    public String creatToken(String id, Map<String, Object> subject) {
        Date nowDate = new Date();
        // 失效时间
        Date expireDate = new Date(nowDate.getTime() + this.jwtConfigProperties.getExpire() * 1000);
        Map <String, Object> claims = new HashMap<>(); // 附件的claims信息
        claims.put("site","www.yitong.com");
        claims.put("book","springboot");
        claims.put("company","屹通科技");
        Map<String,Object> header = new HashMap<>();
        header.put("author","xueyan");
        header.put("modeal",this.applicationName);
        header.put("desc","header desc");
        // 通过Jwts生成token
        String token =  Jwts.builder()
                .setClaims(claims)
                .setHeader(header)
                .setId(id)
                .setIssuedAt(nowDate) // 设置证书签发日期
                .setIssuer(this.jwtConfigProperties.getIssure()) // 设置证书签发者
                .setSubject(JSONObject.toJSONString(subject)) // 附件信息
                .signWith(this.signatureAlgorithm,this.generalKey())
                .setExpiration(expireDate).compact(); // 设置失效时间
        return token;
    }

    @Override
    public Jws<Claims> parseToken(String token) throws JwtException { // 解析token
        if(this.verifyToken(token)){
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(this.generalKey()).parseClaimsJws(token);
            return claimsJws;
        }
        return null;
    }

    @Override
    public boolean verifyToken(String token) {
        try {
            Jwts.parser().setSigningKey(this.generalKey()).parseClaimsJws(token).getBody();
            return  true;
        }catch (JwtException e){
            return false;
        }
    }

    @Override
    public String refershToken(String token) {
        if(this.verifyToken(token)){
           Jws<Claims> claimsJws = this.parseToken(token);
           return this.creatToken(claimsJws.getBody().getId(),
                   JSONObject.parseObject(claimsJws.getBody().getSubject(),Map.class));
        }
        return null;
    }
}
