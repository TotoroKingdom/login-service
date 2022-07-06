package com.totoro.controller;


import com.totoro.auth.LoginService;
import com.totoro.domain.model.AjaxResult;
import com.totoro.domain.model.LoginBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("login")
    public AjaxResult login(@RequestBody LoginBody loginBody){

        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword());
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("token",token);
        return ajaxResult;

    }
}

