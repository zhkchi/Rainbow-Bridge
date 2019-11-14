package com.zhkchi.rainbowbridge.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhkchi.rainbowbridge.modules.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * @author zhkchi
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 账号名称
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐加密
     */
    private String salt;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 工号
     */
    private String jobNum;


    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 用户类型（00系统用户）
     */
    private String userType;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 最后登陆IP
     */
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    private Date lastLoginDate;

    private Integer status;


}
