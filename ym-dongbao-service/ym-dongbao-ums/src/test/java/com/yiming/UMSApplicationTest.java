package com.yiming;

import com.alibaba.druid.pool.DruidDataSource;
import com.yiming.entity.UmsMember;
import com.yiming.service.UmsMemberService;
import com.yiming.service.impl.UmsMemberServiceImpl;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2020/12/25 20:25
 */
@SpringBootTest
public class UMSApplicationTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void ContextLoadsTest() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource)dataSource;
        System.out.println(druidDataSource.getMaxActive());
        System.out.println(druidDataSource.getInitialSize());
        connection.close();
    }

    

    @Test
    public void testInsert() {
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername("张三");
        umsMember.setPassword("123");
        umsMember.setNickName("小三");
        umsMember.setNote("我是一个粉刷匠");
        umsMember.setEmail("1921682112@gmail.com");

        UmsMemberService umsMemberService = new UmsMemberServiceImpl();
        umsMemberService.insertMember(umsMember);
    }
}
