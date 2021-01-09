package com.yiming.dongbao.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2020/12/31 9:58
 */
@SpringBootApplication(scanBasePackages = {"com.yiming"})
@MapperScan(basePackages = {"com.yiming.dongbao.ums.mapper"})
public class DongBaoPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DongBaoPortalApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
