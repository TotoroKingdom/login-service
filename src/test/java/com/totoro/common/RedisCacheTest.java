package com.totoro.common;

import com.totoro.domain.entity.SysUser;
import com.totoro.domain.model.LoginUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisCacheTest {

    @Resource
    private RedisCache redisCache;

    @Test
    void getCacheObject() {
        LoginUser o = redisCache.getCacheObject("Nlrjmasd00gc4kslb5");
        String token = o.getToken();
        SysUser user = o.getUser();
        System.out.println(token);
        System.out.println(user);
    }
}