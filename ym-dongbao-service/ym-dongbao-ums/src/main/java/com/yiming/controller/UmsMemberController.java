package com.yiming.controller;

import com.alibaba.fastjson.JSONObject;
import com.yiming.entity.UmsMember;
import com.yiming.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2020/12/26 00:00
 */
@Controller
public class UmsMemberController {

    @Autowired
    UmsMemberService umsMemberService;

    @RequestMapping(value = "/registerMember", method = RequestMethod.POST)
    @ResponseBody
    public String registerMember(@RequestParam(name = "umsMember") UmsMember umsMember) {
        umsMemberService.insertMember(umsMember);
        return "success";
    }

    @RequestMapping("/selectMemberById")
    @ResponseBody
    public String selectMemberById(@RequestParam(name = "id") Integer id) {
        UmsMember umsMember = umsMemberService.selectMemberById(id);
        return JSONObject.toJSONString(umsMember);
    }

    @RequestMapping("/registerMemberName")
    @ResponseBody
    public String registerMemberName(@RequestParam String username) {
        umsMemberService.insertMemberByName(username);
        return "success";
    }

}
