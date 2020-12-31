package com.yiming.controller;

import com.alibaba.fastjson.JSONObject;
import com.yiming.entity.UmsMember;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
class UmsMemberControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private MockHttpSession session;
    private UmsMember umsMember;
    private String toJSONString;

    @BeforeEach
    void setUpMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();//初始化MockMvc对象

        umsMember = new UmsMember();
        umsMember.setUsername("sb");
        umsMember.setPassword("123");
        umsMember.setNickName("小三");
        umsMember.setNote("我是一个粉刷匠");
        umsMember.setEmail("1921682112@gmail.com");

        toJSONString = JSONObject.toJSONString(umsMember);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void registerMember() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/umsMember/insert")

                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("success"))
                .andDo(MockMvcResultHandlers.print());
    }

}