package com.example.server.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DataDTO {

    @Size(max = 255)
    @DataIdValid
    private String id;

    @Size(max = 255)
    private String endYear;

    private Integer intensity;

    @Size(max = 255)
    private String sector;

    @Size(max = 255)
    private String topic;

    private String insight;

    private String url;

    @Size(max = 255)
    private String region;

    @Size(max = 255)
    private String startYear;

    private String impact;

    private String added;

    private String published;

    @Size(max = 255)
    private String country;

    private Integer relevance;

    @Size(max = 255)
    private String pestle;

    @Size(max = 255)
    private String source;

    private String title;

    private Integer likelihood;

}
