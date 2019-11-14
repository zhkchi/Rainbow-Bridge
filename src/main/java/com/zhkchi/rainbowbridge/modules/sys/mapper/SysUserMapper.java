package com.zhkchi.rainbowbridge.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhkchi.rainbowbridge.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhkchi
 */
@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUserEntity> {


}
