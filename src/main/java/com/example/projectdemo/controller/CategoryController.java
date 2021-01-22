package com.example.projectdemo.controller;

import com.example.projectdemo.dto.request.CategoryRequestDto;
import com.example.projectdemo.service.abstr.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getCategoryList() {
        return categoryService.getCategoryList();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.createCategory(categoryRequestDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.updateCategory(id, categoryRequestDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCategory(@PathVariable("id") Long id) {
        return categoryService.getCategory(id);
    }
}
