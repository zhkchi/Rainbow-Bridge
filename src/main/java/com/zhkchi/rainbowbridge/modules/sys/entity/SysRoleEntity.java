package com.zhkchi.rainbowbridge.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhkchi.rainbowbridge.modules.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 角色表 sys_role
 *
 * @author zhkchi
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色排序
     */
    private Integer sort;

    /**
     * 数据范围（1：所有数据权限；2：本部门及以下数据权限；3：个人数据）
     */
    private String dataScope;

    /**
     * 状态（0:停用 1：启用）
     */
    private Integer status;

    /**
     * 系统默认（0:否 1：是）
     */
    private Integer isSystem;

    /**
     * 数据权限配置状态：1-已配置；0-未配置
     */
    private Integer isSetDataScope;

    /**
     * 菜单权限配置状态：1-已配置；0-未配置
     */
    private Integer isSetMenuScope;

    /**
     * tenantId
     */
    private Integer tenantId;

    /**
     * 菜单组
     */
    @TableField(exist = false)
    private List<Integer> menuIds;

    /**
     * 部门组（数据权限）
     */
    @TableField(exist = false)
    private List<Integer> deptIds;

}


