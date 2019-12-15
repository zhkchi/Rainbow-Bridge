package com.zhkchi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhkchi.domain.RbPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wedbet
 */
public interface RbPermissionMapper extends BaseMapper<RbPermission> {
    /**
     * 根据用户Id查询权限集合
     * @param userId
     * @return
     */
    List<RbPermission> getPermissionsByUserId(@Param("userId") Long userId);
}