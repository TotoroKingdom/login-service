package com.totoro.auth;

import com.totoro.dao.SysUserDao;
import com.totoro.domain.entity.SysUser;
import com.totoro.domain.model.LoginUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

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
        //用户信息会放到这里去UserDetails 从authentication.getPrincipal()里可以拿到
        return createLoginUser(user);
    }

    public UserDetails createLoginUser(SysUser user){
        Set<String> permissions = new HashSet<>();
        LoginUser loginUser = new LoginUser(user, permissions);
        return loginUser;
    }
}
