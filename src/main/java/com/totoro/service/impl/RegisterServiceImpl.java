package com.totoro.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.hutool.core.util.ObjectUtil;
import com.totoro.common.enums.UserStatus;
import com.totoro.dao.SysUserDao;
import com.totoro.domain.entity.SysUser;
import com.totoro.domain.model.AjaxResult;
import com.totoro.domain.model.LoginBody;
import com.totoro.email.Mail;
import com.totoro.service.RegisterService;
import com.totoro.utils.TokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    final private SysUserDao userDao;
    final private Mail mail;

    @Override
    public AjaxResult register(LoginBody loginBody) {

        SysUser existUser = userDao.findByUserName(loginBody.getEmail());
        if (ObjectUtil.isNotNull(existUser)){
            return AjaxResult.success("该邮箱已注册！");
        }

        SysUser user = new SysUser();
        user.setUserName(loginBody.getEmail());
        user.setEmail(loginBody.getEmail());
        user.setPassword(BCrypt.hashpw(loginBody.getPassword()));
        String code = TokenUtils.getRegisterCode();
        user.setRegisterCode(code);
        user.setStatus(UserStatus.UNREGISTERED.getCode());
        SysUser save = userDao.save(user);
        //发邮件
        mail.send(loginBody.getEmail(),"注册激活邮件",code);
        return AjaxResult.success("你已经注册成功!请去邮箱激活");

    }

    @Override
    public AjaxResult active(String code) {

        SysUser user = userDao.findByRegisterCode(code);
        if (ObjectUtil.isNotNull(user)){
            user.setStatus(UserStatus.OK.getCode());
            user.setRegisterCode("-1");
            SysUser sysUser = userDao.saveAndFlush(user);
            return AjaxResult.success("你已经激活成功，请去登录！");

        }


        return AjaxResult.success("你的激活码有误，请重新激活");
    }


}
