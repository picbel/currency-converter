package com.converter.currency.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.text.DecimalFormat;
import java.util.Objects;

@Getter
@Builder
public class ExchangeRateDTO {
    String name;
    String code;
    Double exchangeRate;

    public ExchangeRateDTO(String name, String code, Double exchangeRate) {
        this.name = name;
        this.code = code;
        DecimalFormat df = new DecimalFormat("0.00");
        this.exchangeRate = Double.valueOf(df.format(exchangeRate));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRateDTO that = (ExchangeRateDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(exchangeRate, that.exchangeRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, exchangeRate);
    }
}
