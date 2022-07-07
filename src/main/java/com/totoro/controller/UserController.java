package com.totoro.controller;

import com.totoro.domain.model.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-06 22:28
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {


    /**
     * 请求头必须是Bearertoken
     * @return
     */
    @PostMapping("info")
    public AjaxResult login(){
        log.info("哈哈哈哈哈哈");
        // TODO: 2022-07-06 角色
        // TODO: 2022-07-06 权限
        AjaxResult result = AjaxResult.success();
//        result.put("roles", roles);
//        result.put("permissions", permissions);
        return result;

    }


}
