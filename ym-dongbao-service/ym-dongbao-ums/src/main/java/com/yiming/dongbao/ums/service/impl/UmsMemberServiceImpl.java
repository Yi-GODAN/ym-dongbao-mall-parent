package com.yiming.dongbao.ums.service.impl;

import com.yiming.dongbao.ums.api.entity.UmsMember;
import com.yiming.dongbao.ums.mapper.UmsMemberMapper;
import com.yiming.dongbao.ums.api.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author YiMing
 * @since 2020-12-30
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    public UmsMember selectUmsMember(Integer id) {
        UmsMember umsMember = umsMemberMapper.selectUmsMember(id);
        return umsMember;
    }

}
