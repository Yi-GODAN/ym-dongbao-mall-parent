package com.yiming.dongbao.portal.controller;

import com.yiming.dongbao.ums.api.entity.UmsMember;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberLoginParamDTO;
import com.yiming.dongbao.ums.api.entity.dto.UmsMemberRegisterParamDTO;
import com.yiming.dongbao.ums.api.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author YiMing
 * @since 2020-12-30
 */
@Controller
@RequestMapping("/umsMember")
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
    public String registerMember(@RequestBody UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        int register = umsMemberService.Register(umsMemberRegisterParamDTO);
        if (register == 1) {
            return "register success!!!";
        } else {
            return "register failed!!!";
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public String loginValidate(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO){
        int count = umsMemberService.selectUmsMemberByName(umsMemberLoginParamDTO);
        if (count == 1) {
            return "login success!!!";
        } else {
            return "username not found!!!";
        }
    }

}