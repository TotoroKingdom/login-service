package com.totoro.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.totoro.common.RedisCache;
import com.totoro.dao.NoticeDao;
import com.totoro.domain.entity.Notice;
import com.totoro.service.NoticeService;
import com.totoro.utils.TimeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-09 21:45
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDao noticeDao;
    private final RedisTemplate redisTemplate;
    private final RedisCache redisCache;


    @Override
    public Notice getFortune() {
        String userId = StpUtil.getLoginIdAsString();
        Notice notice = redisCache.getCacheObject(userId);
        if (ObjectUtil.isNotNull(notice)){
            return notice;
        }

        List<Notice> all = noticeDao.findAll();
        Random random = new Random();
        int i = random.nextInt(all.size());
        Notice randomNotice = all.get(i);
        //存入redis
        redisCache.setCacheObject(userId,randomNotice, TimeUtils.todayResidueMinutes(), TimeUnit.MINUTES);

        return randomNotice;
    }
}
