package com.mall.common.exception;

import com.mall.common.api.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: mall-springclound
 * @description: 全局异常处理
 * @author: gaojme
 * @create: 2020-03-30 16:33
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler(value = ApiException.class)  //添加统一的异常处理控制器的方法
    public CommonResult handle(ApiException e) {
        if (e.getErrorCode() != null ) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }


}
