package com.totoro.domain.model;

import lombok.Data;

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
    private String password;
}
