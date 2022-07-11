package com.totoro.common;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class RedisCacheTest {

    @Resource
    private RedisCache redisCache;

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void getCacheObject() {

        try{
            redisTemplate.opsForValue().set("abc","abc");
            Object c = redisTemplate.opsForValue().get("abc");
            System.out.println(c);
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}