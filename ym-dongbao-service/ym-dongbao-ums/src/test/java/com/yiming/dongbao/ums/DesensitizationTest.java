package com.yiming.dongbao.ums;

import com.yiming.dongbao.ums.api.entity.UmsMember;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description: 数据脱敏
 * @Author: YiMing
 * @Created: 2021/01/09 14:55
 */
public class DesensitizationTest {

    /**
     * DigestUtils加密
     */
    @Test
    public void MD5Test01() {
        String sourceString = "123";
        String s1 = DigestUtils.md5DigestAsHex(sourceString.getBytes());

        System.out.println("第一次加密：" + s1);

        String s2 = DigestUtils.md5DigestAsHex(sourceString.getBytes());

        System.out.println("第二次加密：" + s2);
    }

    /**
     * BCryptPasswordEncoder 加密
     */
    @Test
    public void MD5Test02() {
        String sourceString = "123";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode1 = bCryptPasswordEncoder.encode(sourceString);
        System.out.println("第一次加密：" + encode1);
        boolean matches1 = bCryptPasswordEncoder.matches(sourceString, encode1);
        System.out.println("第一次验证：" + matches1);

        String encode2 = bCryptPasswordEncoder.encode(sourceString);
        System.out.println("第一次加密：" + encode2);
        boolean matches2 = bCryptPasswordEncoder.matches(sourceString, encode2);
        System.out.println("第一次验证：" + matches2);
    }
}
