package com.totoro.email;

public interface Mail {

    /**
     * 发注册邮件
     * @param receiver 接收者邮箱
     * @param subject 主题
     * @param text 内容
     */
    void send(String receiver, String subject, String text);

    /**
     * 构建注册邮件模板
     * @param code
     * @return
     */
    String buildContent(String code);
}
