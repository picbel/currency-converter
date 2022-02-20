package com.converter.currency.config;

import com.converter.currency.util.httpUtil.RestTemplateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
       return RestTemplateUtils.restTemplateFactory();
    }
}
