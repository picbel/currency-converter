package com.converter.currency.service;

import com.converter.currency.model.dto.CurrencyResponseDTO;
import com.converter.currency.model.dto.ExchangeRateDTO;
import com.converter.currency.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Log4j2
@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final RestTemplate restTemplate;

    public List<ExchangeRateDTO> getUsedExchangeRateList() throws Exception {
        Map<String,String> currencyKrName = new HashMap<>();
        currencyKrName.put("USDKRW", "한국(KRW)");
        currencyKrName.put("USDJPY", "일본(JPY)");
        currencyKrName.put("USDPHP", "필리핀(PHP)");

        return getExchangeRateAll().entrySet().stream()
                .filter(entry -> currencyKrName.containsKey(entry.getKey()))
                .map(entry -> new ExchangeRateDTO(currencyKrName.get(entry.getKey()),entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    private Map<String,Double> getExchangeRateAll() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        String url = Constants.CURRENCYLAYER_API_URL + "live?access_key="+Constants.API_ACCESS_KEY;

        ResponseEntity<CurrencyResponseDTO> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, CurrencyResponseDTO.class);
        log.info(new ObjectMapper().writeValueAsString(exchange.getBody()));
        return Objects.requireNonNull(exchange.getBody()).getQuotes();
    }
}
