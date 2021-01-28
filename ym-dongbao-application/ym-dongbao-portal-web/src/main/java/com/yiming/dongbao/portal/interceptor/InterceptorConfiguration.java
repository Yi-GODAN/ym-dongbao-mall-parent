package com.yiming.dongbao.portal.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2021/01/28 12:42
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/ums-member/login", "/ums-member/register");
    }

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

}
