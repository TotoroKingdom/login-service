package com.totoro.controller;


import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.totoro.auth.LoginService;
import com.totoro.common.constant.Constants;
import com.totoro.domain.model.AjaxResult;
import com.totoro.domain.model.LoginBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;

    @PostMapping("login")
    public AjaxResult login(@RequestBody LoginBody loginBody){
        String token = loginService.login(loginBody);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return AjaxResult.success(token);

    }
}

