package com.example.projectdemo.dto.mapper;

import com.example.projectdemo.dto.request.CategoryRequestDto;
import com.example.projectdemo.dto.response.CategoryResponseDto;
import com.example.projectdemo.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper { //This layer is right below Service layer

    private CategoryMapper() {}

    public static CategoryResponseDto toDto(Category category) {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();

        categoryResponseDto.setCreatedAt(category.getCreatedAt().toInstant().getEpochSecond()); //Instead of return a Date -> return to Long for easier rendering
        categoryResponseDto.setModifiedAt(category.getModifiedAt().toInstant().getEpochSecond());
        categoryResponseDto.setCreatedBy(category.getCreatedBy());
        categoryResponseDto.setModifiedBy(category.getModifiedBy());
        categoryResponseDto.setName(category.getName());
        categoryResponseDto.setCode(category.getCode());

        return categoryResponseDto;
    }

    public static List<CategoryResponseDto> toListDto(List<Category> categoryList) {
        List<CategoryResponseDto> categoryResponseDto = new ArrayList<>();

        for (Category categoryItem : categoryList) {
            categoryResponseDto.add(toDto(categoryItem));
        }

        return categoryResponseDto;
    }

    public static Category createFromDto(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();

        category.setCreatedBy(categoryRequestDto.getCreatedBy());
        category.setModifiedBy((categoryRequestDto.getModifiedBy()));
        category.setName(categoryRequestDto.getName());
        category.setCode(categoryRequestDto.getCode());

        return category;
    }

    public static Category updateFromDto(Category category, CategoryRequestDto categoryRequestDto) {

        if (categoryRequestDto.getCreatedBy() != null) {
            category.setCreatedBy(categoryRequestDto.getCreatedBy());
        }

        if (categoryRequestDto.getModifiedBy() != null) {
            category.setModifiedBy(categoryRequestDto.getModifiedBy());
        }

        if (categoryRequestDto.getName() != null) {
            category.setName(categoryRequestDto.getName());
        }

        if (categoryRequestDto.getCode() != null) {
            category.setCode(categoryRequestDto.getCode());
        }

        return category;
    }
}
