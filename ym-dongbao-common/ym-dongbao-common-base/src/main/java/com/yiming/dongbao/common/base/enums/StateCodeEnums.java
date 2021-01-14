package com.yiming.dongbao.common.base.enums;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description: 状态码枚举类    100-199: 用户业务；200-299: 支付业务的，依次类推。
 * @Author: YiMing
 * @Created: 2021/01/13 18:31
 */
public enum StateCodeEnums {
    /**
     * 请求成功
     */
    SUCCESS(200, "请求成功"),

    /**
     * 用户已存在
     */
    USER_EXISTS(201, "用户已存在"),

    /**
     * 用户已存在
     */
    USER_NOT_EXISTS(201, "用户不存在"),

    /**
     * 密码错误
     */
    PASSWORD_FAILED(203, "密码错误"),

    /**
     * 请求失败
     */
    FAILED(500, "请求失败");

    private int code;
    private String msg;

    StateCodeEnums(int code, String msg) {
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
