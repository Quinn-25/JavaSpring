package com.example.projectdemo.dto.mapper;

import com.example.projectdemo.dto.request.NewsRequestDto;
import com.example.projectdemo.dto.response.NewsResponseDto;
import com.example.projectdemo.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsMapper {

    private NewsMapper() {};

    public static NewsResponseDto toDto(News news) { // tuong dương hàm GET by ? (? dc khai bao tren Service) -> chuyen 1 model(database) thanh response cho frontend
        NewsResponseDto newsResponseDto = new NewsResponseDto();

        newsResponseDto.setId(news.getId());
        newsResponseDto.setCreatedAt(news.getCreatedAt().toInstant().getEpochSecond());
        newsResponseDto.setModifiedAt(news.getModifiedAt().toInstant().getEpochSecond());
        newsResponseDto.setCreatedBy(news.getCreatedBy());
        newsResponseDto.setModifiedBy(news.getModifiedBy());
        newsResponseDto.setTitle(news.getTitle());
        newsResponseDto.setThumbnail(news.getThumbnail());
        newsResponseDto.setShortDescription(news.getShortDescription());
        newsResponseDto.setContent(news.getContent());
        newsResponseDto.setCategoryId(news.getCategoryId());

        return newsResponseDto;
    }

    public static List<NewsResponseDto> toListDto(List<News> newsList) { //  tuong dương hàm GET -> chuyển từ 1 model(database) ra response -> trả ra client
        List<NewsResponseDto> newsResponseDtoList = new ArrayList<>();

        for (News newsItem : newsList) {
            newsResponseDtoList.add(toDto(newsItem));
        }

        return newsResponseDtoList;
    }

    public static News createFromDto(NewsRequestDto newsRequestDto) {  // = POST -> lấy request từ client trả ra model -> cập nhật vào db
        News news = new News();

        news.setCreatedBy(newsRequestDto.getCreatedBy());
        news.setModifiedBy(newsRequestDto.getModifiedBy());
        news.setTitle(newsRequestDto.getTitle());
        news.setThumbnail(newsRequestDto.getThumbnail());
        news.setShortDescription(newsRequestDto.getShortDescription());
        news.setContent(newsRequestDto.getContent());
        news.setCategoryId(newsRequestDto.getCategoryId());

        return news;
    }

    public static News updateFromDto(News news, NewsRequestDto newsRequestDto) { // = UPDATE by ? -> lấy request từ client trả ra model -> cập nhật vào db
        if (newsRequestDto.getCreatedBy() != null) {
            news.setCreatedBy(newsRequestDto.getCreatedBy());
        }

        if (newsRequestDto.getModifiedBy() != null) {
            news.setModifiedBy(newsRequestDto.getModifiedBy());
        }

        if (newsRequestDto.getTitle() != null) {
            news.setTitle(newsRequestDto.getTitle());
        }

        if (newsRequestDto.getThumbnail() != null) {
            news.setThumbnail(newsRequestDto.getThumbnail());
        }

        if (newsRequestDto.getShortDescription() != null) {
            news.setShortDescription(newsRequestDto.getShortDescription());
        }

        if (newsRequestDto.getContent() != null) {
            news.setContent(newsRequestDto.getContent());
        }

        if (newsRequestDto.getCategoryId() != null) {
            news.setCategoryId(newsRequestDto.getCategoryId());
        }

        return news;
    }

}
