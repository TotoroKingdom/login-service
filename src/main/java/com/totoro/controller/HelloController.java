package com.totoro.controller;

import cn.dev33.satoken.stp.StpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
