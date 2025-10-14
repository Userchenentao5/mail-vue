package com.cet.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * token实体
 *
 * @author cet
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenEntity {

    /**
     * 用户名称
     */
    private String username;

    /**
     * token
     */
    private String token;
}
