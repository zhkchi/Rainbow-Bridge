package com.zhkchi.rainbowbridge.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhkchi.rainbowbridge.modules.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 菜单权限表 sys_menu
 *
 * @author zhkchi
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
public class SysMenuEntity extends BaseEntity {

    /**
     * 菜单id
     */
    private Integer id;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 权限标识
     */
    private String perms;

    @TableField(exist = false)
    private List<SysMenuEntity> children;

    @TableField(exist = false)
    private String title;

}
