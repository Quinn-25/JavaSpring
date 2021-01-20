package com.example.projectdemo.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsRequestDto {

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

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("modified_by")
    private String modifiedBy;

}
