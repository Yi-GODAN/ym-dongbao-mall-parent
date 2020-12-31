package com.yiming.dongbao.ums.controller;


import com.yiming.dongbao.ums.entity.UmsMember;
import com.yiming.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/select")
    @ResponseBody
    public String selectMember(Integer id) {
        UmsMember umsMember = umsMemberService.getById(id);
        System.out.println(umsMember);
        return "success";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insertMember(UmsMember umsMember) {
        boolean save = umsMemberService.save(umsMember);
        return "success";
    }

}

