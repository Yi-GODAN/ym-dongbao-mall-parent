package com.yiming.dongbao.portal.controller;

import com.yiming.dongbao.ums.api.entity.UmsMember;
import com.yiming.dongbao.ums.api.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    UmsMemberService umsMemberService;

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
}

