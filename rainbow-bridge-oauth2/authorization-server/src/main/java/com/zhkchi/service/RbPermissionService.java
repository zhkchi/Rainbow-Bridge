package com.zhkchi.service;

import com.zhkchi.domain.RbPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wedbet
 */
public interface RbPermissionService extends IService<RbPermission>{
    /**
     * 根据用户Id获取用户权限的集合
     * @param userId
     * @return
     */
    public List<RbPermission> getPermissionsByUserId(Long userId);

}
