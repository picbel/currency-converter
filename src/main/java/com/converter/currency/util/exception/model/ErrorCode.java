package com.converter.currency.util.exception.model;

public enum ErrorCode {
    API_NOT_REPONSE(500, "API가 정상적으로 응답하지 않습니다. 잠시 후 다시 시도하여주세요.");

    private final int errorCode;
    private final String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    ErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
