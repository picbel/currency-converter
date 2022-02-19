package com.converter.currency.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class CurrencyResponseDTO {
    String terms;
    String privacy;
    String timestamp;
    String source;
    Map<String,Double> quotes = new HashMap<>();

}
