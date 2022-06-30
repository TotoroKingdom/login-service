package com.totoro.controller;

import com.totoro.util.IpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {

    @RequestMapping()
    public String hello(HttpServletRequest request, HttpServletResponse response){
        String ipAddr = IpUtil.getIpAddr(request);
        String browser = request.getHeader("USER-AGENT");
        String result = browser + ":" + ipAddr;
        return result;
    }
}
