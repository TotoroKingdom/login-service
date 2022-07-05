package com.totoro.auth;

import com.totoro.domain.model.LoginUser;
import com.totoro.utils.TokenUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-03 23:06
 */
@Component
public class TokenService {

    /**
     * 创建令牌
     * @param loginUser 用户信息
     * @return 令牌
     */
    public String createToken(LoginUser loginUser) {
        String token = TokenUtil.getToken();
        return token;
    }
}
