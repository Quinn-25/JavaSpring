package com.example.projectdemo.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryResponseDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("created_at") //Snake
    private Long createdAt;     //Camel // return Long instead of Long

    @JsonProperty("modified_at")
    private Long modifiedAt; // return Long instead of Long

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("modified_by")
    private String modifiedBy;

    @JsonProperty("name")
    private String name;

    @JsonProperty("code")
    private String code;
}
