package com.zhkchi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhkchi.mapper.RbPermissionMapper;
import com.zhkchi.domain.RbPermission;
import com.zhkchi.service.RbPermissionService;
/**
 * @author wedbet
 */
@Service
public class RbPermissionServiceImpl extends ServiceImpl<RbPermissionMapper, RbPermission> implements RbPermissionService{
    @Resource
    private RbPermissionMapper rbPermissionMapper;

    @Override
    public List<RbPermission> getPermissionsByUserId(Long userId) {

        return rbPermissionMapper.getPermissionsByUserId(userId);
    }
}
