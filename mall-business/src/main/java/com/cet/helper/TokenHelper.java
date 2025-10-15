package com.cet.helper;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.cet.util.RedisUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 30952
 */
@Slf4j
@Component
public class TokenHelper {

    private static final String TOKEN_PREFIX = "token:";
    private static final String USER_PREFIX = "user:";

    @Value("${mall.mgt.tokenSecret:123456test}")
    private String tokenSecret;

    @Value("${mall.mgt.tokenExpireTimeInRecord:3600}")
    private int tokenExpireTimeInRecord;

    @Resource
    private RedisUtil redisUtil;


    /**
     * 生成token
     *
     * @param userDetails 用户信息
     * @return token
     */
    public String generateToken(UserDetails userDetails) {
        String username = userDetails.getUsername();
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(generateExpired())
                .signWith(SignatureAlgorithm.HS512, tokenSecret)
                .compact();
        redisUtil.set(getTokenKey(username), token, tokenExpireTimeInRecord);
        String userStr = JSONUtil.toJsonStr(userDetails);
        redisUtil.set(getUserKey(username), userStr, tokenExpireTimeInRecord);
        return token;
    }


    private String getTokenKey(String username) {
        return getKey(TOKEN_PREFIX, username);
    }

    private String getUserKey(String username) {
        return getKey(USER_PREFIX, username);
    }


    /**
     * 计算过期时间
     *
     * @return Date
     */
    private Date generateExpired() {
        return new Date(System.currentTimeMillis() + tokenExpireTimeInRecord * 1000);
    }

    private String getKey(String prefix, String userName) {
        return String.format("%s%s", prefix, userName);
    }
}