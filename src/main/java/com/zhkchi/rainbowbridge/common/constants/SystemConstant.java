package com.zhkchi.rainbowbridge.common.constants;

/**
 * 系统通用常量
 */
public class SystemConstant {

    /**
     * 站点管理员标识
     */
    public static final int IS_ADMIN = 1;

    /**
     * 普通用户
     */
    public static final int IS_NORMAL = 0;

    /**
     * 存放Authorization的header字段
     */
    public static final String TOKEN = "token";

    /**
     * token有效期（小时）
     */
    public static final int TOKEN_EXPIRES_HOUR = 72;

    /**
     * 存储当前登录用户信息
     */
    public static final String SESSION_USER = "session_user";

    /**
     * 存储当前登录用户id
     */
    public static final String USER_ID = "userId";

    /** 超级管理员ID */
    public static final String SUPER_ADMIN = "1";

    /** 角色名称是否唯一的返回结果码 */
    public final static String ROLE_NAME_UNIQUE = "0";
    public final static String ROLE_NAME_NOT_UNIQUE = "1";

    /** 工号是否唯一的返回结果码 */
    public final static String JOB_NUM_UNIQUE = "0";
    public final static String JOB_NUM_NOT_UNIQUE = "1";


    /** 证件号是否唯一的返回结果码 */
    public final static String ID_NUM_UNIQUE = "0";
    public final static String ID_NUM_NOT_UNIQUE = "1";

    /** 订单首字母返回结果码 */
    public final static String DOMESTIC = "GN";
    public final static String LEAVE_COUNTRY = "CJ";

}
