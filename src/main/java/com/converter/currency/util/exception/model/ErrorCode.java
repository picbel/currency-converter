package com.converter.currency.util.exception.model;

public enum ErrorCode {
    API_NOT_RESPONSE(500, "API가 정상적으로 응답하지 않습니다. 잠시 후 다시 시도하여주세요.");

    private final int code;
    private final String message;

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
