package com.example.unsplash;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter

public class Urls {

    @JsonProperty("raw")
    private String raw;
    @JsonProperty("regular")
    private String regular;
    private String thumb;


}
