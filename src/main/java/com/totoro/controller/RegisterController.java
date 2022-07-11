package com.totoro.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.totoro.domain.model.AjaxResult;
import com.totoro.domain.model.LoginBody;
import com.totoro.service.RegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("register")
public class RegisterController {

    final private RegisterService registerService;

    @PostMapping("email")
    public AjaxResult login(@RequestBody LoginBody loginBody){
        AjaxResult result = registerService.register(loginBody);
        return AjaxResult.success(result);

    }

    @GetMapping("active")
    public AjaxResult login(@RequestParam("code") String code){
        AjaxResult result = registerService.active(code);
        return AjaxResult.success(result);

    }


}
