package com.converter.currency.util.exception;

import com.converter.currency.util.exception.model.ErrorCode;

public abstract class BusinessException extends RuntimeException{
    private final int code;
    protected BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        code = errorCode.getCode();
    }
}
