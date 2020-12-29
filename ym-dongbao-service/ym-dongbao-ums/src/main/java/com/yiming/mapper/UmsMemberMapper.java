package com.yiming.mapper;

import com.yiming.entity.UmsMember;
import org.springframework.stereotype.Component;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2020/12/25 23:11
 */
@Component
public interface UmsMemberMapper {

    void insertMemberByName(String username);

    void insertMember(UmsMember umsMember);

    UmsMember selectMember(Integer id);
}
