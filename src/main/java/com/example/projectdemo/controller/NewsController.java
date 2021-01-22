package com.example.projectdemo.controller;

import com.example.projectdemo.dto.request.NewsRequestDto;
import com.example.projectdemo.service.abstr.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping
    public ResponseEntity<?> getNewsList() {
        return newsService.getNewsList();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createNews(@RequestBody NewsRequestDto newsRequestDto) {
        return newsService.createNews(newsRequestDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateNews(@PathVariable("id") Long id, @RequestBody NewsRequestDto newsRequestDto) {
        return newsService.updateNews(id, newsRequestDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getNews(@PathVariable("id") Long id) {
        return newsService.getNews(id);
    }

}
