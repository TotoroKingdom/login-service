package com.totoro.service.impl;

import com.totoro.dao.SysUserDao;
import com.totoro.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-05 7:40
 */
@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao userDao;




}
