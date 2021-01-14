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
    public int register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        UmsMember umsMember = new UmsMember();

        // 将给定源bean的属性值复制到目标bean中。
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);

        // 查询用户
        int userCount = umsMemberMapper.selectUmsMemberCount(umsMember.getUsername());

        // 判断用户是否存在
        if (userCount == 1) return 0;

        // 密码加密
        String encode = passwordEncoder.encode(umsMemberRegisterParamDTO.getPassword());
        umsMember.setPassword(encode);

        // 插入数据
        int insertNum = umsMemberMapper.registerUmsMember(umsMember);

        return insertNum == 1 ? 1 : -1;
    }

    /**
     * 登录
     *
     * @param umsMemberLoginParamDTO
     * @return
     */
    public int login(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        UmsMember umsMember = new UmsMember();

        // 将给定源bean的属性值复制到目标bean中。
        BeanUtils.copyProperties(umsMemberLoginParamDTO, umsMember);

        // 查询用户
        QueryWrapper<UmsMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", umsMember.getUsername());
        Integer userCount = umsMemberMapper.selectCount(queryWrapper);

        // 判断用户是否存在
        if (userCount == 0) return userCount;

        // 验证密码
        String password = umsMemberMapper.selectUmsMemberPasswordByName(umsMember.getUsername());
        boolean matches = passwordEncoder.matches(umsMember.getPassword(), password);

        return matches == true ? 1 : -1;
    }

}
