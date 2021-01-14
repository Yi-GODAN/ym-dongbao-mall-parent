package com.yiming.dongbao.ums.api.entity.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotNull(message = "User name cannot be null")
    @Size(min = 1, max = 9, message = "The length of the user name must be within 1-9 characters")
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "User password cannot be empty")
    @NotNull(message = "User password cannot be null")
    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    @Email(message = "It is not a valid e-mail address")
    private String email;

    /**
     * 昵称
     */
    private String nickName;

}
