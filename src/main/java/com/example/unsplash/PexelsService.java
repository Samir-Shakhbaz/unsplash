package com.example.unsplash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PexelsService {

    @Autowired
    WebClient webClient_2;
    Photo getResults;

    public List<Photo> getPhotosPexels(String searchText) {

        return getPhotosPexels(searchText);
    }


    public Mono<Integer> getTotalPagesPexels(String searchText) {

        return webClient_2.get()
                .uri(uri -> uri
                        .queryParam("page", "1")
                        .queryParam("query", searchText).build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(PexelsResponse.class)
                .map(PexelsResponse::getTotalPages)
                .map(Integer::valueOf);
    }

    public Mono<PexelsResponse> searchPexels(String searchText, int pageNumber){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return webClient_2.get()
                .uri(uri -> uri
                        .queryParam("page", pageNumber)
                        .queryParam("query", searchText)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PexelsResponse.class);
    }
}
