package com.totoro.email;

import com.totoro.utils.TokenUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailTest {

    @Autowired
    private Mail mail;

    @Test
    void send() {
        for (int i = 0; i < 10; i++) {

            String receiver = "765830637@qq.com";
            String subject = "注册";
            String code = TokenUtils.getRegisterCode();
            mail.send(receiver,subject,code);
        }

    }

    @Test
    void buildContent() {
    }
}