package com.zhkchi.rainbowbridge.modules.sys.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 登录vo
 *
 * @author zhkchi
 */
@Data
public class LoginVO {

    @NotEmpty(message="姓名不能为空")
    private String account;

    @NotEmpty(message="密码不能为空")
    private String password;

    @NotEmpty(message="验证码不能为空")
    private String verifyCode;
}
