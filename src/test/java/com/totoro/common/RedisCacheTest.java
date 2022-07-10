package com.totoro.common;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@SpringBootTest
class RedisCacheTest {

    @Resource
    private RedisCache redisCache;

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void getCacheObject() {
        String host = "192.168.121.121";
        int port = 6379;
        HostAndPort hostAndPort = new HostAndPort(host,port);
        Jedis jedis = new Jedis(host,port);
        jedis.auth("redis2022");

        try{
            Object o = redisTemplate.opsForValue().get("aa");
            Object c = redisTemplate.opsForValue().get("cc");
            System.out.println(o);
            System.out.println(c);
            jedis.ping();
            System.out.println("=================");
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}