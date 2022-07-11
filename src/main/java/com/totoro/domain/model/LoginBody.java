package com.totoro.domain.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-03 22:33
 */
@Data
public class LoginBody {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String password;

    /**
     * 邮箱
     */
    @NotNull(message = "邮箱不能为空")
    private String email;
}
