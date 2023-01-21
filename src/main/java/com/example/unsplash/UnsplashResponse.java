package com.example.unsplash;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class UnsplashResponse {

    List<Photo> results;

    @JsonProperty("total_pages")
    int totalPages;




}
