package com.hjy;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hjy.utils.Md5Util;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: JwtTest
 * Package: com.hjy
 * Description:
 *
 * @Author 黄嘉宇
 * @Create 2024/5/5 14:40
 * @Version 1.0
 */
public class JwtTest {


    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");
        //生成Jwt的代码
        String token = JWT.create()
                .withClaim("user",claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)) // 添加过期时间
//                .withExpiresAt(new Date(System.currentTimeMillis())) // 添加过期时间
                .sign(Algorithm.HMAC256("wxz"));//指定算法配置密钥
        System.out.println(token);
    }

    @Test
    public void testParse(){
        //模拟用户传递过来的token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MTUxOTAzMzd9" +
                ".-FLLaMQloaWLYoldDbK97UikFsvUh-ZLdB8d8s3Gw5g";
        //生成验证器
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("wxz")).build();

        //验证token，生成一个解析后的JWT对象
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }

    @Test
    public void getPwd(){
        System.out.println(Md5Util.getMD5String("123456"));
    }
}
