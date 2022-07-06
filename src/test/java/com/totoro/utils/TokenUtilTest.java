package com.totoro.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class TokenUtilTest {


    @Test
    void getPwd(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println(encode);
    }

    @Test
    void getToken() {

        String token = TokenUtils.getToken();
        System.out.println(token);

    }
}