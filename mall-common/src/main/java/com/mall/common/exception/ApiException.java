package com.mall.common.exception;

import com.mall.common.api.IErrorCode;

/**
 * @program: mall-springclound
 * @description: 自定义API异常
 * @author: gaojme
 * @create: 2020-03-30 16:29
 */
public class ApiException extends RuntimeException{

    private IErrorCode errorCode;


    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }


    public ApiException(Throwable throwable) {
        super(throwable);
    }

    public ApiException(String message, Throwable throwable){
        super(message, throwable);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }


}
