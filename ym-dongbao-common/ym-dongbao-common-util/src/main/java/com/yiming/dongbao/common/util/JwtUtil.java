package com.yiming.dongbao.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2021/01/19 21:46
 */
public class JwtUtil {

    // 密钥
    private static final String secret = "I'm a Handsome man";

    /**
     * 生成令牌
     *
     * @param subject
     * @return string
     */
    public static String createToken(String subject) {
        return Jwts.builder().setSubject(subject)
                .setExpiration(new Date(System.nanoTime() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /**
     * 解析令牌
     *
     * @param token
     * @return string
     */
    public static String parseToken(String token) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return body.getSubject();
    }

}
