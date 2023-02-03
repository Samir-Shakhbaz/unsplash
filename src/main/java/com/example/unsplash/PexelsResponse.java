package com.example.unsplash;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PexelsResponse {

    List<Photo> results;
    private Integer total;
    @JsonProperty("total_pages")
    int totalPages;


}
