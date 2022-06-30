package com.totoro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping()
    public String hello(){
        String s = "哈哈哈哈 加班真快乐啊 我是真的很快乐";
        return s;
    }
}
