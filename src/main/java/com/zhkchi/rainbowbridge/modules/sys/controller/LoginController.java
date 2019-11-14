package com.zhkchi.rainbowbridge.modules.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhkchi.rainbowbridge.common.util.R;
import com.zhkchi.rainbowbridge.modules.sys.entity.SysUserEntity;
import com.zhkchi.rainbowbridge.modules.sys.service.SysUserService;
import com.zhkchi.rainbowbridge.modules.sys.vo.LoginVO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author zhkchi
 */
@RestController
@AllArgsConstructor
public class LoginController {

    SysUserService sysUserService;

    /**
     * 登录接口
     * 流程：
     * 1：账号是否存在；2：账号是否停用；3：账号是否过期；4：密码是否正确
     * @param loginVO 登录vo
     * @return R
     */
    @RequestMapping("login")
    public R login(@RequestBody @Valid LoginVO loginVO){
        return sysUserService.login(loginVO);
    }

}
