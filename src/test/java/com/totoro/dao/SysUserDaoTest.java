package com.totoro.dao;

import com.totoro.domain.entity.SysUser;
import com.totoro.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class SysUserDaoTest {

    @Resource
    private SysUserDao userDao;

    @Resource
    private SysUserService userService;

    @Test
    public void test(){
        SysUser totoro = userDao.getByUserName("totoro");
        System.out.println(totoro);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println(encode);

    }

}