package com.totoro.dao;

import com.totoro.domain.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-05 7:34
 */
public interface SysUserDao extends JpaRepository<SysUser,Long>, JpaSpecificationExecutor<SysUser> {

    SysUser findByUserName(String username);

    SysUser findByRegisterCode(String registerCode);

}
