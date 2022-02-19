package com.converter.currency.controller;

import com.converter.currency.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/list")
    public ResponseEntity<?> exchangeRateList() throws Exception {
        return new ResponseEntity<>(currencyService.getExchangeRateList(), HttpStatus.OK);
    }


}
