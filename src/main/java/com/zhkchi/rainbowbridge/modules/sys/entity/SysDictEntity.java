package com.zhkchi.rainbowbridge.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhkchi.rainbowbridge.modules.base.BaseEntity;
import lombok.Data;

/**
 * 字典表 sys_dict
 *
 * @author zhkchi
 */
@Data
@TableName("sys_dict")
public class SysDictEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 字典排序
     */
    private Integer sort;

    /**
     * 字典标签
     */
    private String label;

    /**
     * 字典键值
     */
    private Integer value;

    /**
     * 字典类型
     */
    private Integer type;

    /**
     * 状态（0:停用 1：启用）
     */
    private Integer status;

    /**
     * tenantId
     */
    private Integer tenantId;
}
