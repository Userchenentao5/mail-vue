package com.cet.auth;


import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 权限用户实体
 *
 * @author cet
 */
@Data
public class AuthUserEntity {

    /**
     * 用户名称
     */
    @NotBlank(message = "用户名称不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @NotBlank
    private String password;

    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String code;

    /**
     * 手机号
     */
    private String phone;
}
