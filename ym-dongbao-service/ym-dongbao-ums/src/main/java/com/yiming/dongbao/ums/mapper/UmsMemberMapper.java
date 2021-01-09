package com.yiming.dongbao.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yiming.dongbao.ums.api.entity.UmsMember;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author YiMing
 * @since 2020-12-30
 */
@Repository
public interface UmsMemberMapper extends BaseMapper<UmsMember> {

    UmsMember selectUmsMember(Integer id);

    int registerUmsMember(UmsMember umsMember);

    UmsMember selectUmsMemberByName(String username);
}
