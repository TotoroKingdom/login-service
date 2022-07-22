package com.totoro.service;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.codec.Decoder;
import cn.hutool.http.HttpUtil;
import com.totoro.dao.NoticeDao;
import com.totoro.domain.entity.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.util.DecodeUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeServiceTest {

    @Resource
    NoticeDao noticeDao;

    @Test
    void decoder(){

        String s = Base64.decodeStr(" 4oCU4oCU5pyr5ZCJ4oCU4oCUCuepuuS4reeahOS6keWxguWBj+S9ju+8jOW5tuS4lOS7jeacieWghuenr+S5i+WKv++8jArkuI3nn6XkvZXml7bpm7fpm6jkvJrpqqTnhLbku47lpLTpobblgL7nm4bogIzkuIvjgIIK5L2G5piv562J6Zu36Zuo6L+H5ZCO77yM6L+Y5Lya5pyJ5b2p6Jm55Zyo562J552A44CCCuWunOW+quS6juaXp++8jOWuiOS6jumdme+8jOiLpeWmhOS4uuWImemavuaIkOS5i+OAggoK5LuK5aSp55qE5bm46L+Q54mp5pivOuagkeS4iuaOieiQveeahOOAjOadvuaenOOAjeOAggrlubbkuI3mmK/miYDmnInnmoTmnb7mnpzpg73og73plb/miJDpq5jlpKfnmoTmnb7moJHvvIwK5oiQ6ZW/6ZyA6KaB6YCC5a6c55qE546v5aKD77yM5pu06ZyA6KaB5LiA54K56L+Q5rCU44CCCuaJgOS7peS4jeeUqOe7meiHquW3sei/h+WkmuWOi+WKm++8jOiAkOW/g+etieW+heW9qeiZueWQp+OAgg==");
        System.out.println(s);

        RestTemplate restTemplate = new RestTemplate();

    }

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