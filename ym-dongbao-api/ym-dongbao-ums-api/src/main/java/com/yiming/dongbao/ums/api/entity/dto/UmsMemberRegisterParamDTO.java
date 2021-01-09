package com.yiming.dongbao.ums.api.entity.dto;

import lombok.Data;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description: DTO：封装注册需要传递的参数
 * @Author: YiMing
 * @Created: 2021/01/09 13:11
 */
@Data
public class UmsMemberRegisterParamDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

}
