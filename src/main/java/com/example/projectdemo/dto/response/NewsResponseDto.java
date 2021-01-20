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
public class NewsResponseDto {

    @JsonProperty("id")
    private Long id;

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

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("modified_at")
    private Long modifiedAt;

    @JsonProperty("modified_by")
    private String modifiedBy;

}
