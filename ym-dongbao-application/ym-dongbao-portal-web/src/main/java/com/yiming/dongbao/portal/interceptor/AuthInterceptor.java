package com.yiming.dongbao.portal.interceptor;

import com.mysql.cj.util.StringUtils;
import com.yiming.dongbao.common.base.annotations.TokenCheck;
import com.yiming.dongbao.common.base.exception.TokenException;
import com.yiming.dongbao.common.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2021/01/28 12:48
 */
public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("AuthInterceptor preHandle parameter request:{}, response:{}, handler:{}", request, response, handler);

        String accessToken = request.getHeader("accessToken");

        String refreshToken = request.getHeader("refreshToken");

        if (StringUtils.isNullOrEmpty(accessToken)) {
            log.error("AuthInterceptor preHandle accessToken is null!");
            throw new TokenException("accessToken 为空");
        }

        if (StringUtils.isNullOrEmpty(refreshToken)) {
            log.error("AuthInterceptor preHandle refreshToken is null!");
            throw new TokenException("refreshToken 为空");
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(TokenCheck.class)) {
            TokenCheck annotation = method.getAnnotation(TokenCheck.class);
            if (annotation.required()) {
                // 校验accessToken
                try {
                    JwtUtil.parseToken(accessToken);
                } catch (Exception e) {
                    log.error("AuthInterceptor preHandle accessToken is error!");
                    try {
                        // 校验refreshToken
                        JwtUtil.parseToken(refreshToken);
                    } catch (Exception ex) {
                        log.error("AuthInterceptor preHandle refreshToken is error!");
                        throw new TokenException("refreshToken 异常");
                    }
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
