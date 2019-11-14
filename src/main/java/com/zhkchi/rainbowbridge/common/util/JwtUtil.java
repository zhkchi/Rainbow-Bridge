package com.zhkchi.rainbowbridge.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author zhkchi
 */
public class JwtUtil {

    /**
     * 密码
     */
    public final static String BASE64SECRET = "i7fIdppPPT4ixfiDia9S0MNm1tmfO8MfmoagaAZZ0wFe";

    /**
     * 过期时间1天
     */
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;

    /**
     * 校验token是否正确
     *
     * @param token 密钥
     * @return 是否正确
     */
    public static boolean verify(String token) {
        try {
            Jwts.parser()
                .setSigningKey(BASE64SECRET)
                .parseClaimsJws(token)
                .getBody();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getAccount(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username")
                      .asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名
     *
     * @param username 用户名
     * @return 加密的token
     */
    public static String generateToken(String username) {

        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return Jwts.builder()
                   .setSubject(username)
                   .claim("username", username)
                   .setExpiration(date)
                   .signWith(SignatureAlgorithm.HS256, BASE64SECRET)
                   .compact();
    }
}
