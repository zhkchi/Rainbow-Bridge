package com.zhkchi.rainbowbridge.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhkchi.rainbowbridge.common.util.R;
import com.zhkchi.rainbowbridge.modules.sys.entity.SysUserEntity;
import com.zhkchi.rainbowbridge.modules.sys.vo.LoginVO;

/**
 * @author zhkchi
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 用户登录方法
     *
     * @param loginVO
     * @return
     */
    R login(LoginVO loginVO);

}
