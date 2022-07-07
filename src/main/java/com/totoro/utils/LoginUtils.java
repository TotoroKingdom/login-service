package com.totoro.utils;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.stp.StpUtil;
import com.totoro.common.enums.DeviceType;
import com.totoro.domain.model.LoginUser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 *  * 登录鉴权助手
 *  *
 *  * user_type 为 用户类型 同一个用户表 可以有多种用户类型 例如 pc,app
 *  * deivce 为 设备类型 同一个用户类型 可以有 多种设备类型 例如 web,ios
 *  * 可以组成 用户类型与设备类型多对多的 权限灵活控制
 *  *
 *  * 多用户体系 针对 多种用户类型 但权限控制不一致
 *  * 可以组成 多用户类型表与多设备类型 分别控制权限
 * @Author totoro
 * @Date 2022-07-08 0:15
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginUtils {

    public static final String JOIN_CODE = ":";
    public static final String LOGIN_USER_KEY = "loginUser";

    /**
     * 登录系统 基于 设备类型
     * 针对相同用户体系不同设备
     * @param loginUser 登录用户信息
     */
    public static void loginByDevice(LoginUser loginUser, DeviceType deviceType) {
        SaHolder.getStorage().set(LOGIN_USER_KEY, loginUser);
        StpUtil.login(loginUser.getLoginId(), deviceType.getDevice());
        StpUtil.getTokenSession().set(LOGIN_USER_KEY, loginUser);
    }




}
