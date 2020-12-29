package com.yiming;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2020/12/25 18:44
 */
@SpringBootApplication
@MapperScan("com.yiming.mapper")
public class UMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(UMSApplication.class, args);
    }
}
