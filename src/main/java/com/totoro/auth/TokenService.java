package com.totoro.auth;

import com.totoro.domain.model.LoginUser;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-03 23:06
 */
public class TokenService {

    /**
     * 创建令牌
     * @param loginUser 用户信息
     * @return 令牌
     */
    public String createToken(LoginUser loginUser) {
//        String token = IdUtils.fastUUID();
//        loginUser.setToken(token);
//        setUserAgent(loginUser);
//        refreshToken(loginUser);
//
//        Map<String, Object> claims = new HashMap<>();
//        claims.put(Constants.LOGIN_USER_KEY, token);
//        String token1 = createToken(claims);
        return null;
    }
}
