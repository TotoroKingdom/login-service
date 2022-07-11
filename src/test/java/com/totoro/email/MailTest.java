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
       String receiver = "634581304@qq.com";
       String subject = "注册激活邮件";
       String code = TokenUtils.getRegisterCode();
       mail.send(receiver,subject,code);

    }

    @Test
    void buildContent() {
    }
}