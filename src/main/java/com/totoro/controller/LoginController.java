package com.totoro.controller;


import com.totoro.domain.model.AjaxResult;
import com.totoro.domain.model.LoginBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {



    @PostMapping
    public AjaxResult login(@RequestBody LoginBody loginBody){
        return null;

    }
}

