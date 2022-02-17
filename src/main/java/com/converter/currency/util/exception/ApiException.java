package com.converter.currency.util.exception;

import com.converter.currency.util.exception.model.ErrorCode;

public class ApiException extends BusinessException{
    public ApiException(ErrorCode errorCode) {
        super(errorCode);
    }
}
