package com.example.projectdemo.service.abstr;

import com.example.projectdemo.dto.request.NewsRequestDto;
import com.example.projectdemo.dto.response.NewsResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NewsService {

    ResponseEntity<List<NewsResponseDto>> getNewsList();

    ResponseEntity<NewsResponseDto> createNews(NewsRequestDto newsRequestDto);

    ResponseEntity<NewsResponseDto> updateNews(Long id, NewsRequestDto newsRequestDto);

    ResponseEntity<NewsResponseDto> getNews(Long id);

}
