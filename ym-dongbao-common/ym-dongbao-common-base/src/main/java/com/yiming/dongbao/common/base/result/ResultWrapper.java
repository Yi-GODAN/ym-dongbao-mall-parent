package com.yiming.dongbao.common.base.result;

import com.yiming.dongbao.common.base.enums.StateCodeEnums;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2021/01/13 18:33
 */
@Data
@Builder
public class ResultWrapper<T> implements Serializable {

    // 状态码
    private int code;

    // 提示信息
    private String msg;

    // 传输的数据
    private T data;

    /**
     * 返回成功的包装类
     *
     * @return ResultWrapper
     */
    public static ResultWrapper.ResultWrapperBuilder getSuccessBuilder() {
        return ResultWrapper.builder().code(StateCodeEnums.SUCCESS.getCode()).msg(StateCodeEnums.SUCCESS.getMsg());
    }

    /**
     * 返回失败的包装类
     *
     * @return ResultWrapper
     */
    public static ResultWrapper.ResultWrapperBuilder getFailedBuilder() {
        return ResultWrapper.builder().code(StateCodeEnums.FAILED.getCode()).msg(StateCodeEnums.FAILED.getMsg());
    }

    /**
     * 返回用户已存在的包装类
     *
     * @return ResultWrapper
     */
    public static ResultWrapper.ResultWrapperBuilder getUserExistsBuilder() {
        return ResultWrapper.builder().code(StateCodeEnums.USER_EXISTS.getCode()).msg(StateCodeEnums.USER_EXISTS.getMsg());
    }

    /**
     * 返回用户不存在的包装类
     *
     * @return ResultWrapper
     */
    public static ResultWrapper.ResultWrapperBuilder getUserNotExistsBuilder() {
        return ResultWrapper.builder().code(StateCodeEnums.USER_NOT_EXISTS.getCode()).msg(StateCodeEnums.USER_NOT_EXISTS.getMsg());
    }

    /**
     * 返回密码错误的包装类
     *
     * @return ResultWrapper
     */
    public static ResultWrapper.ResultWrapperBuilder getPasswordFiledBuilder() {
        return ResultWrapper.builder().code(StateCodeEnums.PASSWORD_FAILED.getCode()).msg(StateCodeEnums.PASSWORD_FAILED.getMsg());
    }

}
