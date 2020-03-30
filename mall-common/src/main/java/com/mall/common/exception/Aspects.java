package com.mall.common.exception;

import com.mall.common.api.IErrorCode;

/**
 * @program: mall-springclound
 * @description: 断言处理类，用于抛出各种API异常
 * @author: gaojme
 * @create: 2020-03-30 16:31
 */
public class Aspects {

    public static void fail(String message){
        throw new ApiException(message);
    }


    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }


}
