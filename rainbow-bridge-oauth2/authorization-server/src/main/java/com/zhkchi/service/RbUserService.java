package com.zhkchi.service;

import com.zhkchi.domain.RbUser;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * @author wedbet
 */
public interface RbUserService extends IService<RbUser>{
    /**
     *  根据用户名获取用户信息
     * @param username
     * @return
     */
    public RbUser getRbUserByUserName(String username);

}
