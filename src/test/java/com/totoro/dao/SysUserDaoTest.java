package com.totoro.dao;

import com.totoro.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SysUserDaoTest {

    @Resource
    private SysUserDao userDao;

    @Resource
    private SysUserService userService;

    @Test
    public void test(){


    }

}