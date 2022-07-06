package com.totoro.auth;

import cn.hutool.core.util.StrUtil;
import com.totoro.common.RedisCache;
import com.totoro.domain.model.LoginUser;
import com.totoro.utils.TokenUtils;
import com.totoro.common.constant.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-03 23:06
 */
@Component
public class TokenService {

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    // 令牌自定义标识 Authorization
    @Value("${token.header}")
    private String header;

    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int expireTime;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisCache redisCache;



    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public LoginUser getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (StrUtil.isNotEmpty(token)){
            //获取redis里的用户信息
            LoginUser loginUser = redisCache.getCacheObject(token);
            return loginUser;

        }
        return null;
    }

    /**
     * 创建令牌
     * @param loginUser 用户信息
     * @return 令牌
     */
    public String createToken(LoginUser loginUser) {
        String token = TokenUtils.getToken();
        loginUser.setToken(token);
        //将用户信息保存到redis并且刷新
        refreshToken(loginUser);
        return token;
    }


    /**
     * 获取请求头里的token
     * @param request
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (StrUtil.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)){
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }

    /**
     * 刷新令牌有效期
     * @param loginUser 登录信息
     */
    public void refreshToken(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
        // 根据token将loginUser缓存
        redisTemplate.opsForValue().set(loginUser.getToken(), loginUser, expireTime, TimeUnit.MINUTES);
    }




}
