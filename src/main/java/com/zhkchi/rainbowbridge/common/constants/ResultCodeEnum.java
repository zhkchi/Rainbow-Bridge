package com.zhkchi.rainbowbridge.common.constants;


public enum ResultCodeEnum {

    /**
     * 成功
     */
    SUCCESS(0, "操作成功"),

    /**
     * 失败
     */
    ERROR(-1, "操作失败"),


    /**
     * 账号已驳回
     */
    REJECT(-2, "账号已驳回！"),

    /**
     * 账号审核中
     */
    AUDITING(-3, "账号审核中！"),

    /**
     * 异常
     */
    FAILED(90000001, "系统错误"),

    /**
     * 未登录/token过期
     */
    UNAUTHORIZED(90000001, "获取登录用户信息失败"),

    /**
     * 失败
     */
    PARAM_ERROR(90000003, "参数错误"),

    /**
     * 用户名或密码错误
     */
    INVALID_USERNAME_PASSWORD(10000003, "用户名或密码错误"),

    /**
     *
     */
    INVALID_RE_PASSWORD(10000010, "两次输入密码不一致"),

    /**
     * 用户名或密码错误
     */
    INVALID_PASSWORD(10000009, "旧密码错误"),


    INVALID_PASSWORD_WX(10000011, "旧密码不正确，请重新输入！"),

    /**
     * 用户名重复
     */
    USERNAME_ALREADY_IN(10000002, "用户已存在"),

    /**
     * 用户不存在
     */
    INVALID_USER(10000001, "用户不存在"),

    /**
     * 角色不存在
     */
    INVALID_ROLE(10000004, "角色不存在"),

    /**
     * 角色不存在
     */
    ROLE_USER_USED(10000008, "角色使用中，不可删除"),

    /**
     * 参数错误-已存在
     */
    INVALID_PARAM_EXIST(10000005, "请求参数已存在"),

    /**
     * 参数错误
     */
    INVALID_PARAM_EMPTY(10000006, "请求参数为空"),

    /**
     * 没有权限
     */
    USER_NO_PERMITION(10000007, "当前用户无该接口权限");

    public int code;

    public String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
