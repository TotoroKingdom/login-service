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
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("hello")
    public Map<Object, Object> hello(HttpServletRequest request, HttpServletResponse response){
        HashMap<Object, Object> result = new HashMap<>();
        result.put("hello","world");
        return result;
    }
}
