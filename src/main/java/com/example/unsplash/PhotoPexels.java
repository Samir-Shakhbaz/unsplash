package com.example.unsplash;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter


public class PhotoPexels {

    private String id;
    @JsonProperty("alt")
    private String alt_description;
    private Urls urls;

}