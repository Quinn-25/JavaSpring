package com.example.projectdemo.service.abstr;

import com.example.projectdemo.dto.request.CategoryRequestDto;
import com.example.projectdemo.dto.response.CategoryResponseDto;
import com.example.projectdemo.model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    ResponseEntity<List<CategoryResponseDto>> getCategoryList();

    ResponseEntity<CategoryResponseDto> createCategory(CategoryRequestDto categoryRequestDto);

    ResponseEntity<CategoryResponseDto> updateCategory(Long id, CategoryRequestDto categoryRequestDto);

    ResponseEntity<CategoryResponseDto> getCategory(Long id);
}
