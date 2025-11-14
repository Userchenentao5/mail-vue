package com.cet.helper;


import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.cet.auth.JwtUserEntity;
import com.cet.exception.BusinessException;
import com.cet.util.RedisUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @author 30952
 */
@Slf4j
@Component
public class TokenHelper {

    private static final String TOKEN_PREFIX = "token:";

    private static final String USER_PREFIX = "user:";

    @Getter
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

    /**
     * 从token中解析出username
     *
     * @param token token
     * @return username
     */
    public String getUsernameFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        if (Objects.isNull(claims)) {
            return null;
        }
        return claims.getSubject();
    }

    /**
     * 获得 Claims
     *
     * @param token Token
     * @return Claims
     */

    public Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                .setSigningKey(getTokenSecret())
                .parseClaimsJws(token)
                .getBody();
        } catch (Exception e) {
            log.info("获得 Claims失败：", e);
            // throw new BusinessException(HttpStatus.FORBIDDEN.hashCode(), "请先登录");
            // claims = null;
            throw new BusinessException(HttpStatus.FORBIDDEN.value(), "请先登录");
        }
        return claims;
    }


    private String getTokenKey(String username) {
        return getKey(TOKEN_PREFIX, username);
    }

    private String getUserKey(String username) {
        return getKey(USER_PREFIX, username);
    }

    /**
     * 根据用户名称查询用户详情信息
     *
     * @param username 用户名称
     * @return 用户详情
     */
    public UserDetails getUserDetailsFromUsername(String username) {
        String userKey = getUserKey(username);
        String userDetailJson = redisUtil.get(userKey);
        if (!StringUtils.hasLength(userDetailJson)) {
            return null;
        }
        try {
            // 确保是字符串格式再解析
            return JSON.parseObject(userDetailJson, JwtUserEntity.class);
        } catch (Exception e) {
            log.error("解析用户详情失败，username: {}, userDetailJson: {}", username, userDetailJson, e);
            return null;
        }
    }

    /**
     * 计算过期时间
     *
     * @return Date
     */
    private Date generateExpired() {
        return new Date(System.currentTimeMillis() + tokenExpireTimeInRecord * 1000L);
    }

    private String getKey(String prefix, String userName) {
        return String.format("%s%s", prefix, userName);
    }
}