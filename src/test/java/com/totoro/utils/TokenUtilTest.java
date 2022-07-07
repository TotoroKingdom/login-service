package com.totoro.utils;

import cn.dev33.satoken.secure.BCrypt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TokenUtilTest {


    @Test
    void getPwd(){
        String hashpw = BCrypt.hashpw("123456");
        System.out.println(hashpw);

    }

    @Test
    void getToken() {

        String token = TokenUtils.getToken();
        System.out.println(token);

    }
}