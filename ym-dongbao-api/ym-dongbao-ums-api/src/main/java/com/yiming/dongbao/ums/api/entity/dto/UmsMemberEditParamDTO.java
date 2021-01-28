package com.yiming.dongbao.ums.api.entity.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2021/01/28 14:05
 */
@Data
public class UmsMemberEditParamDTO {

    /**
     * id
     */
    @NotNull(message = "ID was error")
    private Long id;

    /**
     * 用户名
     */
    @NotNull(message = "User name cannot be null")
    @Size(min = 1, max = 9, message = "The length of the user name must be within 1-9 characters")
    private String username;

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

    /**
     * 备注信息
     */
    private String note;

}
