package com.yiming.dongbao.ums.api.service;

import com.yiming.dongbao.common.base.result.ResultWrapper;
import com.yiming.dongbao.ums.api.entity.UmsMember;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberEditParamDTO;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberLoginParamDTO;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberRegisterParamDTO;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author YiMing
 * @since 2020-12-30
 */
public interface UmsMemberService {

    UmsMember selectUmsMember(Integer id);

    ResultWrapper register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);

    ResultWrapper login(UmsMemberLoginParamDTO umsMemberLoginParamDTO);

    ResultWrapper edit(UmsMemberEditParamDTO umsMemberEditParamDTO);
}
