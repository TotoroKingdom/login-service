package com.totoro.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TokenUtilTest {

    @Test
    void getToken() {

        String token = TokenUtil.getToken();
        System.out.println(token);

    }
}