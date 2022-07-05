package com.totoro.controller;

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.useragent.Browser;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.totoro.util.RequestUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String clientIP = ServletUtil.getClientIP(request);
        String name = UserAgentUtil.parse(request.getHeader("user-agent")).getBrowser().getName();
        String result = name + ": " + clientIP;
        return result;
    }
}
