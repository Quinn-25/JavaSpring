package com.example.projectdemo.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsResponseDto extends AbstractResponseDto{ //response request vào tầng dto thay vì trực tiếp vào model

    @JsonProperty("title")
    private String title;

    @JsonProperty("thumbnail")
    private String thumbnail;

    @JsonProperty("short_description")
    private String shortDescription;

    @JsonProperty("content")
    private String content;

    @JsonProperty("category_id")
    private Long categoryId;

}
