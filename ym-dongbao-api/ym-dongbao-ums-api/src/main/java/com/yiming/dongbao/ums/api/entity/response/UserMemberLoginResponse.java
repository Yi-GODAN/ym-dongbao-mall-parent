package com.yiming.dongbao.ums.api.entity.response;

import com.yiming.dongbao.ums.api.entity.UmsMember;
import lombok.Data;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description: 返回的登录实体类
 * @Author: YiMing
 * @Created: 2021/01/27 22:56
 */
@Data
public class UserMemberLoginResponse {

    /**
     * 令牌
     */
    private String token;

    /**
     * UmsMember
     */
    private UmsMember umsMember;
}
