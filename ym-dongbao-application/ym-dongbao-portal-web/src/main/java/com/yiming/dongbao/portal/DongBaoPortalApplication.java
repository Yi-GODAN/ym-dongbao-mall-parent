package com.yiming.dongbao.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2020/12/31 9:58
 */
@SpringBootApplication(scanBasePackages = {"com.yiming.dongbao.ums", "com.yiming.dongbao.portal"})
@MapperScan(basePackages = {"com.yiming.dongbao.ums.mapper"})
public class DongBaoPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DongBaoPortalApplication.class, args);
    }
}
