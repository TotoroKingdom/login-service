package com.totoro.auth;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.totoro.common.enums.DeviceType;
import com.totoro.common.enums.UserStatus;
import com.totoro.common.exception.UserException;
import com.totoro.common.exception.UtilException;
import com.totoro.dao.SysUserDao;
import com.totoro.domain.entity.SysUser;
import com.totoro.domain.model.LoginBody;
import com.totoro.domain.model.LoginUser;
import com.totoro.service.SysUserService;
import com.totoro.utils.LoginUtils;
import com.totoro.utils.ServletUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-07 23:49
 */
//代替@Autowired
@RequiredArgsConstructor
@Slf4j
@Service
public class LoginService {

    private static final String LOGIN_USER_KEY = "loginUser";
    private final SysUserService userService;
    private final SysUserDao userDao;

    /**
     * 登录验证
     * @param username 用户名
     * @param password 密码
     * @param code     验证码
     * @param uuid     唯一标识
     * @return 结果
     */
    public String login(LoginBody loginBody) {
        HttpServletRequest request = ServletUtils.getRequest();
        //获取用户信息
        SysUser user = loadUserByUsername(loginBody.getUsername());
        boolean checkpw = BCrypt.checkpw(loginBody.getPassword(), user.getPassword());
        if (!checkpw){
            throw new UtilException("账号或者密码错误");
        }
        // 此处可根据登录用户的数据不同 自行创建 loginUser
        LoginUser loginUser = buildLoginUser(user);
        // 生成token
        LoginUtils.loginByDevice(loginUser,DeviceType.PC);
        return StpUtil.getTokenValue();
    }

    private SysUser loadUserByUsername(String username) {
        SysUser user = userDao.findByUserName(username);
        if (ObjectUtil.isNull(user)) {
            log.info("登录用户：{} 不存在.", username);
            throw new UserException("user.not.exists", username);
        } else if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            log.info("登录用户：{} 已被删除.", username);
            throw new UserException("user.password.delete", username);
        } else if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            log.info("登录用户：{} 已被停用.", username);
            throw new UserException("user.blocked", username);
        }else if( UserStatus.UNREGISTERED.getCode().equals(user.getStatus())){
            log.info("登录用户: {} 未激活。");
            throw new UserException("用户未激活", username);
        }
        return user;
    }

    /**
     * 构建登录用户
     */
    private LoginUser buildLoginUser(SysUser user) {
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(user.getId());
        loginUser.setDeptId(user.getDeptId());
        loginUser.setUsername(user.getUserName());
//        loginUser.setUserType(user.getUserType());
//        loginUser.setMenuPermission(permissionService.getMenuPermission(user));
//        loginUser.setRolePermission(permissionService.getRolePermission(user));
//        loginUser.setDeptName(ObjectUtil.isNull(user.getDept()) ? "" : user.getDept().getDeptName());
//        List<RoleDTO> roles = BeanUtil.copyToList(user.getRoles(), RoleDTO.class);
//        loginUser.setRoles(roles);
        return loginUser;
    }


}
