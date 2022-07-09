package com.totoro.service;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpUtil;
import com.totoro.dao.NoticeDao;
import com.totoro.domain.entity.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeServiceTest {

    @Resource
    NoticeDao noticeDao;

    @Test
    void getFortune() {

        String s = HttpUtil.get("https://adachi-bot.oss-cn-beijing.aliyuncs.com/Version2/slip/index.yml");
        String[] split = s.split("-");
        for (int i = 0; i < split.length; i++) {
            String s2 = split[i];
            Notice notice = new Notice();
            notice.setContent(s2);
            noticeDao.save(notice);

        }


    }
}