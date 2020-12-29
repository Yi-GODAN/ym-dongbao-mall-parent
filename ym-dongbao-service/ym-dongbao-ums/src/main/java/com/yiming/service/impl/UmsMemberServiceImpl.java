package com.yiming.service.impl;

import com.yiming.entity.UmsMember;
import com.yiming.mapper.UmsMemberMapper;
import com.yiming.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2020/12/26 00:04
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    UmsMemberMapper memberMapper;

    @Override
    public void insertMember(UmsMember umsMember) {
        memberMapper.insertMember(umsMember);
    }

    @Override
    public UmsMember selectMemberById(Integer id) {
        UmsMember umsMember = memberMapper.selectMember(id);
        System.out.println(umsMember);
        return umsMember;
    }

    @Override
    public void insertMemberByName(String username) {
        memberMapper.insertMemberByName(username);
    }
}
