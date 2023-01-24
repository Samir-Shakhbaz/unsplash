package com.example.unsplash;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter


public class Photo {

    private String id;
    @JsonProperty("alt_description")
    private String description;
    private Urls urls;

}
