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
     * 登录令牌
     */
    private String accessToken;

    /**
     * 刷新令牌
     */
    private String refreshToken;

    /**
     * UmsMember
     */
    private UmsMember umsMember;
}
