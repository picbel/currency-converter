package com.converter.currency.service;

import com.converter.currency.model.dto.CurrencyResponseDTO;
import com.converter.currency.util.Constants;
import com.converter.currency.util.httpUtil.RestTemplateUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Log4j2
@Service
public class CurrencyService {

    private final RestTemplate restTemplate = RestTemplateUtils.restTemplateFactory();

    public Map<String,Double> getExchangeRateList() throws Exception {
        List<String> useExchangeRateKey = Arrays.asList("USDKRW","USDJPY","USDPHP");
        return getExchangeRateAll().entrySet().stream()
                .filter(entry -> useExchangeRateKey.contains(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    private Map<String,Double> getExchangeRateAll() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        String url = Constants.CURRENCYLAYER_API_URL + "live?access_key="+Constants.API_ACCESS_KEY;

        ResponseEntity<CurrencyResponseDTO> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, CurrencyResponseDTO.class);

        return Objects.requireNonNull(exchange.getBody()).getQuotes();
    }
}
