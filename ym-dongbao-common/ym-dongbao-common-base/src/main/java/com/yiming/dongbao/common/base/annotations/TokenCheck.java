package com.yiming.dongbao.common.base.annotations;

import java.lang.annotation.*;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description: 自定义令牌校验注解
 * @Author: YiMing
 * @Created: 2021/01/28 12:37
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenCheck {

    /**
     * 是否校验token
     * @return boolean
     */
    boolean required() default true;

}
