package com.totoro.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;


/**
 * 用户对象 sys_user
 *
 * @author wintersnow
 * @since 1.0  2020-12-11
 */
@Data
@Entity
@Table(name = "sys_user")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SysUser {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    /**
     * 部门ID
     */
    @Column(name = "dept_id")
    private Long deptId;

    /**
     * 用户账号
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 用户邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 手机号码
     */
    @Column(name = "phonenumber")
    private String phonenumber;

    /**
     * 用户性别
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 用户头像
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 帐号状态（0正常 1停用）
     */
    @Column(name = "status")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 最后登录IP
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 最后登录时间
     */
    @Column(name = "login_date")
    private Date loginDate;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 备注
     */
    @Column(name = "version")
    private int version;

    /**
     * 部门对象
     */
//    @Transient
//    private SysDept dept;


    /**
     * 角色对象
     */
//    @Transient
//    private List<SysRole> roles;

    /**
     * 盐加密
     */
    @Transient
    private String salt;

    /**
     * 角色组
     */
    @Transient
    private Long[] roleIds;

    /**
     * 岗位组
     */
    @Transient
    private Long[] postIds;

}
