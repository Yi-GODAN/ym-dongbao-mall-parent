package com.yiming.dongbao.portal.controller;

import com.yiming.dongbao.common.base.result.ResultWrapper;
import com.yiming.dongbao.common.util.JwtUtil;
import com.yiming.dongbao.ums.api.entity.UmsMember;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberLoginParamDTO;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberRegisterParamDTO;
import com.yiming.dongbao.ums.api.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        int register = umsMemberService.register(umsMemberRegisterParamDTO);
        return register == 0 ? ResultWrapper.getUserExistsBuilder().data(null).build() :
                register == 1 ? ResultWrapper.getSuccessBuilder().data(null).build() :
                        ResultWrapper.getFailedBuilder().data(null).build();

    }

    @RequestMapping("/login")
    @ResponseBody
    public ResultWrapper loginValidate(@RequestBody @Valid UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        int count = umsMemberService.login(umsMemberLoginParamDTO);
        return count == 0 ? ResultWrapper.getUserNotExistsBuilder().data(null).build() :
                count == 1 ? ResultWrapper.getSuccessBuilder().data(null).build() :
                        ResultWrapper.getPasswordFiledBuilder().data(null).build();
    }

    /**
     * 测试
     *
     * @param subject
     * @return
     */
    @GetMapping("/test-verify")
    public String verify(String subject) {
        String token = JwtUtil.createToken(subject);
        System.out.println("token:" + token);
        String parseToken = JwtUtil.parseToken(token);
        System.out.println("parseToken:" + parseToken);
        return token;
    }
}