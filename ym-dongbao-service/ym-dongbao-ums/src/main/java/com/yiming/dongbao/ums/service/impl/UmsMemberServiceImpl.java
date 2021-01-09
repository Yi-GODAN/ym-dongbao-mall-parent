package com.yiming.dongbao.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yiming.dongbao.ums.api.entity.UmsMember;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberLoginParamDTO;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberRegisterParamDTO;
import com.yiming.dongbao.ums.api.service.UmsMemberService;
import com.yiming.dongbao.ums.mapper.UmsMemberMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    UmsMemberMapper umsMemberMapper;

    PasswordEncoder passwordEncoder;

//    @Autowired
//    public UmsMemberServiceImpl(UmsMemberMapper umsMemberMapper) {
//        this.umsMemberMapper = umsMemberMapper;
//    }

    @Autowired
    public UmsMemberServiceImpl(UmsMemberMapper umsMemberMapper, PasswordEncoder passwordEncoder) {
        this.umsMemberMapper = umsMemberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UmsMember selectUmsMember(Integer id) {
        UmsMember umsMember = umsMemberMapper.selectUmsMember(id);
        return umsMember;
    }

    /**
     * 注册
     *
     * @param umsMemberRegisterParamDTO
     * @return
     */
    @Override
    public int Register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        UmsMember umsMember = new UmsMember();

        // 将给定源bean的属性值复制到目标bean中。
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);

        // 密码加密
        String encode = passwordEncoder.encode(umsMemberRegisterParamDTO.getPassword());
        System.out.println("加密后的encode:" + encode);

        umsMember.setPassword(encode);
        System.out.println(umsMember);

        // 插入数据
        int insertNum = umsMemberMapper.registerUmsMember(umsMember);
        return insertNum;
    }

    public int selectUmsMemberByName(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
//        UmsMember umsMember = umsMemberMapper.selectUmsMemberByName(username);
        UmsMember umsMember = new UmsMember();

        // 将给定源bean的属性值复制到目标bean中。
        BeanUtils.copyProperties(umsMemberLoginParamDTO, umsMember);

        // 查询用户是否存在
        QueryWrapper<UmsMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", umsMember.getUsername());
        return umsMemberMapper.selectCount(queryWrapper);
    }
}
