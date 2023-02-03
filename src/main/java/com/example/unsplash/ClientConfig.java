package com.example.unsplash;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@Configuration
public class ClientConfig {

    @Value("${search.uri}")
    private URI searchUri;

    @Value("${api.client-id}")
    private String secret;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(searchUri.toString())
                .defaultHeader(HttpHeaders.AUTHORIZATION, secret)
                .build();
    }

    @Value("${search.uri_2}")
    private URI searchUri_2;

    @Value("${api.client-id_2}")
    private String secret_2;

    @Qualifier
    @Bean
    public WebClient webClient_2() {
        return WebClient.builder()
                .baseUrl(searchUri_2.toString())
                .defaultHeader(HttpHeaders.AUTHORIZATION, secret_2)
                .build();
    }

}
