package com.converter.currency.config;

import com.converter.currency.util.exception.ApiException;
import com.converter.currency.util.exception.BusinessException;
import com.converter.currency.util.exception.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(value = {ApiException.class })
//    protected ResponseEntity<ErrorResponse> handleCustomException(BusinessException e) {
////        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
//        return ErrorResponse.toResponseEntity(e.getErrorCode());
//    }
}
