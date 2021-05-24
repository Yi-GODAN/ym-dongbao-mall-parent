package com.yiming.dongbao.portal.controller;

import com.yiming.dongbao.common.base.annotations.TokenCheck;
import com.yiming.dongbao.common.base.result.ResultWrapper;
import com.yiming.dongbao.ums.api.entity.UmsMember;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberEditParamDTO;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberLoginParamDTO;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberRegisterParamDTO;
import com.yiming.dongbao.ums.api.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author YiMing
 * @since 2020-12-30
 */
@Controller
@RequestMapping("/ums-member")
public class UmsMemberController {

    UmsMemberService umsMemberService;

    @Autowired
    public UmsMemberController(UmsMemberService umsMemberService) {
        this.umsMemberService = umsMemberService;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping("/select")
    @ResponseBody
    public String selectMember(@RequestParam Integer id) {
        UmsMember umsMember = umsMemberService.selectUmsMember(id);
        System.out.println(umsMember);
        return "success";
    }

    @RequestMapping("/register")
    @ResponseBody
    public ResultWrapper registerMember(@RequestBody @Valid UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        return umsMemberService.register(umsMemberRegisterParamDTO);
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResultWrapper loginValidate(@RequestBody @Valid UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        return umsMemberService.login(umsMemberLoginParamDTO);
    }

    @RequestMapping("/edit")
    @ResponseBody
    @TokenCheck
    public ResultWrapper edit(@RequestBody @Valid UmsMemberEditParamDTO umsMemberEditParamDTO) {
        return umsMemberService.edit(umsMemberEditParamDTO);
    }
}