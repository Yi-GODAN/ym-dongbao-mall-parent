package com.yiming.service;

import com.yiming.entity.UmsMember;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2020/12/26 00:03
 */
public interface UmsMemberService {

    void insertMember(UmsMember umsMember);

    UmsMember selectMemberById(Integer id);

    void insertMemberByName(String username);
}
