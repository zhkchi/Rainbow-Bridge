package com.zhkchi.rainbowbridge.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhkchi.rainbowbridge.modules.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 部门表 sys_dept
 *
 * @author zhkchi
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dept")
public class SysDeptEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    private Integer id;

    /**
     * 父部门ID
     */
    private Integer parentId;

    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 部门状态（0:停用 1：启用）
     */
    private Integer status;

    /**
     * 系统默认（0:否 1：是）
     */
    private Integer isSystem;

    /**
     * tenant_id
     */
    private Integer tenantId;

    /**
     * 父部门名称
     */
    @TableField(exist = false)
    private String parentName;

    /**
     * 标题
     */
    @TableField(exist = false)
    private String title;

    @TableField(exist = false)
    List<SysDeptEntity> children;

}
