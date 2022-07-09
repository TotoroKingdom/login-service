package com.totoro.service;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpUtil;
import com.totoro.dao.NoticeDao;
import com.totoro.domain.entity.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

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

            String s1 = Base64.decodeStr(split[i]);
            System.out.println(s1);
            Notice notice = new Notice();
            notice.setContent(s1);
            Notice save = noticeDao.save(notice);

        }


    }
}