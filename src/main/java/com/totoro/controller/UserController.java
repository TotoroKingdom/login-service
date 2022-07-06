package com.totoro.controller;

import com.totoro.auth.TokenService;
import com.totoro.domain.entity.SysUser;
import com.totoro.domain.model.AjaxResult;
import com.totoro.domain.model.LoginBody;
import com.totoro.domain.model.LoginUser;
import com.totoro.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-06 22:28
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private TokenService tokenService;

    /**
     * 请求头必须是Bearertoken
     * @return
     */
    @PostMapping("info")
    public AjaxResult login(){
        log.info("哈哈哈哈哈哈");
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        // TODO: 2022-07-06 角色
        // TODO: 2022-07-06 权限
        AjaxResult result = AjaxResult.success();
        result.put("user",user);
//        result.put("roles", roles);
//        result.put("permissions", permissions);
        return result;

    }


}
