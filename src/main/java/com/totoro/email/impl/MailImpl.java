package com.totoro.email.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.template.TemplateEngine;
import com.totoro.email.Mail;
import com.totoro.utils.TokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailImpl implements Mail {

    final private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;


    @Override
    public void send(String receiver, String subject, String text) {



        String content = buildContent(text);

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(fromEmail);
            helper.setSubject(subject);
            helper.setTo(receiver);
            helper.setText(content,true);
            mailSender.send(message);
            log.info("邮件发送成功");
        } catch (MessagingException e) {
            log.info("邮件发送失败");
            e.printStackTrace();
        }

        return;
    }

    @Override
    public String buildContent(String code) {

        //加载邮件html模板
        Resource resource = new ClassPathResource("static/mailtemplate.ftl");
        try {
            log.info("resource="+resource.getURL());
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream inputStream = null;
        BufferedReader fileReader = null;
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            inputStream = resource.getInputStream();
            fileReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = fileReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            log.info("发送邮件读取模板失败{}", e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //替换html模板中的参数
        return MessageFormat.format(buffer.toString(), code);
    }


}
