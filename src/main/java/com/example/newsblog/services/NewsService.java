package com.example.newsblog.services;

import com.example.newsblog.exeptions.NewsNotFoundEx;
import com.example.newsblog.models.News;
import com.example.newsblog.repositiries.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;


@Component
public class NewsService {

    private NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public NewsService() {
    }

    public void addNews(News news){newsRepository.save(news);}

    public News getNewsById(Long id) throws NewsNotFoundEx {
        Iterable <News> newsById = newsRepository.findAllById(Collections.singleton(id));
        return (News) newsById;
    }
}
