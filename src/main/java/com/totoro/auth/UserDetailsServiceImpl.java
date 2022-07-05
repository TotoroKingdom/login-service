package com.totoro.auth;

import com.totoro.dao.SysUserDao;
import com.totoro.domain.entity.SysUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-05 7:46
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userDao.getByUserName(username);
        if (user.getPassword() == null){
            throw new UsernameNotFoundException("登录失败，用户名或者密码错误");
        }

        UserDetails userDetails = User.withUsername(username)
                .password(user.getPassword())
                .roles("user")
                .build();
        return userDetails;
    }
}
