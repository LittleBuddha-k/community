package com.littlebuddha.community.base.exception.serviceexception;

import com.littlebuddha.community.base.exception.errorcode.IErrorCode;

public class CustomizeException extends RuntimeException {

    private String message;
    private Integer code;

    public CustomizeException(IErrorCode iErrorCode){
        this.code = iErrorCode.getCode();
        this.message = iErrorCode.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
