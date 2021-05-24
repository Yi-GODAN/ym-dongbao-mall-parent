package com.yiming.dongbao.portal.advice;

import com.yiming.dongbao.common.base.exception.TokenException;
import com.yiming.dongbao.common.base.result.ResultWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Program: ym-dongbao-mall-parent
 * @Description:
 * @Author: YiMing
 * @Created: 2021/01/14 15:26
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResultWrapper customException() {
        return ResultWrapper.builder().code(301).msg("算术异常").build();
    }

    /**
     * 自定义token异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(TokenException.class)
    public ResultWrapper loginException(Exception e) {
        return ResultWrapper.getFailedBuilder().msg(e.getMessage()).build();
    }

}
