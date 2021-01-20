package com.example.projectdemo.service.impl;

import com.example.projectdemo.dto.mapper.NewsMapper;
import com.example.projectdemo.dto.request.NewsRequestDto;
import com.example.projectdemo.dto.response.NewsResponseDto;
import com.example.projectdemo.model.News;
import com.example.projectdemo.repository.NewsRepository;
import com.example.projectdemo.service.abstr.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public ResponseEntity<List<NewsResponseDto>> getNewsList() {
        List<NewsResponseDto> newsResponseDtoList = NewsMapper.toListDto(newsRepository.findAll());

        return new ResponseEntity<>(newsResponseDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NewsResponseDto> createNews(NewsRequestDto newsRequestDto) {
        News news = NewsMapper.createFromDto(newsRequestDto);

        news.setCreatedAt(new Date());
        news.setModifiedAt(new Date());

        News createdNews = newsRepository.save(news);

        return new ResponseEntity<>(NewsMapper.toDto(createdNews), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NewsResponseDto> updateNews(Long id, NewsRequestDto newsRequestDto) {
        Optional<News> newsOptional = newsRepository.findById(id);

        if (!newsOptional.isPresent()) {
            throw new RuntimeException(String.format("Can not find news with id: %d", id));
        }

        News news = newsOptional.get();

        News updatedNews = NewsMapper.updateFromDto(news, newsRequestDto);

        updatedNews.setModifiedAt(new Date());

        newsRepository.save(updatedNews);

        return new ResponseEntity<>(NewsMapper.toDto(updatedNews), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NewsResponseDto> getNews(Long id) {
        Optional<News> newsOptional = newsRepository.findById(id);

        if (!newsOptional.isPresent()) {
            throw new RuntimeException(String.format("Can not find news with id: %d", id));
        }

        News news = newsOptional.get();

        return new ResponseEntity<>(NewsMapper.toDto(news), HttpStatus.OK);
    }
}
