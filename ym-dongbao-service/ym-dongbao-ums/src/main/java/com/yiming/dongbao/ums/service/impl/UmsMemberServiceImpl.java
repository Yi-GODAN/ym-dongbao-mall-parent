package com.yiming.dongbao.ums.service.impl;

import com.yiming.dongbao.common.base.result.ResultWrapper;
import com.yiming.dongbao.common.util.JwtUtil;
import com.yiming.dongbao.ums.api.entity.UmsMember;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberEditParamDTO;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberLoginParamDTO;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberRegisterParamDTO;
import com.yiming.dongbao.ums.api.entity.response.UserMemberLoginResponse;
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
    public ResultWrapper register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        UmsMember umsMember = new UmsMember();

        // 将给定源bean的属性值复制到目标bean中。
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);

        // 查询用户
        int userCount = umsMemberMapper.selectUmsMemberCount(umsMember.getUsername());

        // 判断用户是否存在
        if (userCount == 1) return ResultWrapper.getUserExistsBuilder().build();

        // 密码加密
        String encode = passwordEncoder.encode(umsMemberRegisterParamDTO.getPassword());
        umsMember.setPassword(encode);

        // 插入数据
        int insertNum = umsMemberMapper.registerUmsMember(umsMember);

        return insertNum == 1 ? ResultWrapper.getSuccessBuilder().build() : ResultWrapper.getFailedBuilder().build();
    }

    /**
     * 登录
     *
     * @param umsMemberLoginParamDTO
     * @return
     */
    public ResultWrapper login(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        UmsMember umsMember = new UmsMember();

        // 将给定源bean的属性值复制到目标bean中。
        BeanUtils.copyProperties(umsMemberLoginParamDTO, umsMember);

        // 查询用户
        UmsMember umsMemberForName = umsMemberMapper.selectUmsMemberByName(umsMember.getUsername());

        // 判断用户是否存在
        if (umsMemberForName == null) return ResultWrapper.getUserNotExistsBuilder().build();

        // 验证密码
        boolean matches = passwordEncoder.matches(umsMember.getPassword(), umsMemberForName.getPassword());

        // 判断密码是否正确
        if (!matches) {
            return ResultWrapper.getPasswordFiledBuilder().build();
        }

        // 生成token
        String token = JwtUtil.createToken(umsMember.getUsername());

        // 生成返回登录包装类
        UserMemberLoginResponse loginResponse = new UserMemberLoginResponse();

        // 去除密码
        umsMemberForName.setPassword(null);

        // 设置token
        loginResponse.setToken(token);

        // 设置umsMember
        loginResponse.setUmsMember(umsMemberForName);

        return ResultWrapper.getSuccessBuilder().data(loginResponse).build();
    }

    @Override
    public ResultWrapper edit(UmsMemberEditParamDTO umsMemberEditParamDTO) {
        UmsMember umsMember = new UmsMember();

        // 将给定源bean的属性值复制到目标bean中。
        BeanUtils.copyProperties(umsMemberEditParamDTO, umsMember);

        try {
            umsMemberMapper.updateById(umsMember);
        } catch (Exception e) {
            return ResultWrapper.getFailedBuilder().data("用户名已存在").build();
        }

        return ResultWrapper.getSuccessBuilder().data(umsMember).build();

    }

}
