package com.yiming.mapper;

import com.yiming.entity.UmsMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;


@SpringBootTest
class UmsMemberMapperTest {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Test
    void insertMember() {
        UmsMember t = new UmsMember();
        t.setUsername("zhaoliu");
        t.setPassword("123");
        t.setNickName("小三");
        t.setNote("我是一个粉刷匠");
        t.setEmail("1921682112@gmail.com");

        umsMemberMapper.insert(t);

    }

    @Test
    void updateMember() {
        UmsMember t = new UmsMember();
        t.setId(8L);
        t.setPassword("12345");
        umsMemberMapper.updateById(t);
    }
    
}