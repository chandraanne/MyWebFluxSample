package com.chandra.mywebfluxsamples.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class BeanFactory {
    @Value("${mockendpoint}")
    private String baseURL;

    @Bean(name = "WebClient")
    public WebClient getWebClient() {
        return WebClient.builder()
                .baseUrl(baseURL)
                .build();
    }
}
