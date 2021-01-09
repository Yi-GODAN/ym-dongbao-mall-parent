package com.yiming.dongbao.ums.api.entity.dto;

import lombok.Data;

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
    private String username;

    /**
     * 密码
     */
    private String password;
}
