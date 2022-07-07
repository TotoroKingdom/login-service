package com.totoro.common;

import com.totoro.domain.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RedisCacheTest {

    @Resource
    private RedisCache redisCache;

    @Test
    void getCacheObject() {

    }
}