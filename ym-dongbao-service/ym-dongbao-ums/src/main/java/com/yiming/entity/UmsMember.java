package com.yiming.entity;

import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.util.Date;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2020/12/25 22:39
 */
@Data
public class UmsMember {

    private Long id;

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

    /**
     * 备注信息
     */
    private String note;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后登录时间
     */
    private Date loginTime;

    /**
     * 最后修改时间
     */
    private Date updateTime;

    /**
     * 账号启用状态
     */
    private Integer status;
}
