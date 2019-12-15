package com.zhkchi.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author wedbet
 */
@Data
@TableName(value = "rb_user")
public class RbUser implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码，加密存储
     */
    @TableField(value = "password")
    private String password;

    /**
     * 注册手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 注册邮箱
     */
    @TableField(value = "email")
    private String email;

    @TableField(value = "created")
    private Date created;

    @TableField(value = "updated")
    private Date updated;

    private static final long serialVersionUID = 1L;
}