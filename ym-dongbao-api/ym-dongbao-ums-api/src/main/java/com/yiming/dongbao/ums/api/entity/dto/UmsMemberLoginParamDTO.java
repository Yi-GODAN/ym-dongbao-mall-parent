package com.yiming.dongbao.ums.api.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2021/01/09 19:44
 */
@Data
public class UmsMemberLoginParamDTO {

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
}
