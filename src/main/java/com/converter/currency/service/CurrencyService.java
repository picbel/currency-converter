package com.converter.currency.service;

import com.converter.currency.util.exception.ApiException;
import com.converter.currency.util.exception.model.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    public List exchangeRateList() {
        throw new ApiException(ErrorCode.API_NOT_RESPONSE, "환율 API가 응답이 지연되고있습니다.");
    }
}
