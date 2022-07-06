package com.totoro.common;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-06 23:48
 */
@Component
public class RedisCache {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 获得缓存的基本对象。
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    public <T> T getCacheObject(final String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }
}
