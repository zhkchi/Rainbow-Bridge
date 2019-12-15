package com.zhkchi.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhkchi.domain.RbUser;
import com.zhkchi.mapper.RbUserMapper;
import com.zhkchi.service.RbUserService;


/**
 * @author wedbet
 */
@Service
public class RbUserServiceImpl extends ServiceImpl<RbUserMapper, RbUser> implements RbUserService{

    @Resource
    private RbUserMapper rbUserMapper;

    @Override
    public RbUser getRbUserByUserName(String username) {
        QueryWrapper<RbUser> rbUserQueryWrapper = Wrappers.<RbUser>query();
        rbUserQueryWrapper.eq("username","Tony");
        RbUser rbUser = rbUserMapper.selectOne(rbUserQueryWrapper);
        System.out.println(rbUser);
        return rbUser;
    }
}
