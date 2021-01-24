package com.example.projectdemo.service.impl;

import com.example.projectdemo.dto.mapper.CategoryMapper;
import com.example.projectdemo.dto.request.CategoryRequestDto;
import com.example.projectdemo.dto.response.CategoryResponseDto;
import com.example.projectdemo.model.Category;
import com.example.projectdemo.repository.CategoryRepository;
import com.example.projectdemo.service.abstr.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<List<CategoryResponseDto>> getCategoryList() {
        List<CategoryResponseDto> categoryResponseDtoList = CategoryMapper.toListDto(categoryRepository.findAll());

        return new ResponseEntity<>(categoryResponseDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryResponseDto> createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = CategoryMapper.createFromDto(categoryRequestDto);

        category.setCreatedAt(new Date());
        category.setModifiedAt(new Date());

        Category createdCategory = categoryRepository.save(category);

        return new ResponseEntity<>(CategoryMapper.toDto(createdCategory), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryResponseDto> updateCategory(Long id, CategoryRequestDto categoryRequestDto) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (!categoryOptional.isPresent()) {
            throw new RuntimeException(String.format("Cannot find category with id: %d", id));
        }

        Category category = categoryOptional.get();

        Category updateCategory = CategoryMapper.updateFromDto(category, categoryRequestDto);

        updateCategory.setModifiedAt(new Date());

        categoryRepository.save(updateCategory);

        return new ResponseEntity<>(CategoryMapper.toDto(updateCategory), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryResponseDto> getCategory(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (!categoryOptional.isPresent()) {
            throw new RuntimeException(String.format("Cannot find category with id: %d", id));
        }

        Category category = categoryOptional.get();

        return new ResponseEntity<>(CategoryMapper.toDto(category), HttpStatus.OK);
    }
}
