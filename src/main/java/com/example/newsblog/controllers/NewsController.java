package com.example.newsblog.controllers;

import com.example.newsblog.exeptions.LogEx;
import com.example.newsblog.exeptions.NewsNotFoundEx;
import com.example.newsblog.models.News;
import com.example.newsblog.models.User;
import com.example.newsblog.repositiries.NewsRepository;
import com.example.newsblog.services.NewsService;
import com.example.newsblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/news")
public class NewsController {

    private NewsService newsService;
    private NewsRepository newsRepository;
    private UserService userService;

    @Autowired
    public NewsController(NewsService newsService, NewsRepository newsRepository, UserService userService) {
        this.newsService = newsService;
        this.newsRepository = newsRepository;
        this.userService = userService;
    }
    public NewsController() {
    }

    @PostMapping
    public ResponseEntity<String> addNews (@RequestBody News news, @PathVariable User author){
        if(userService.logIn(author.getToken())) throw new LogEx();
        newsService.addNews(news);
        return new ResponseEntity(news,HttpStatus.CREATED);
    }

    @GetMapping
    public List<News> allNews() throws NewsNotFoundEx{
        return newsRepository.findAll();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<String> getNews (@PathVariable("id") News news) throws NewsNotFoundEx{
        newsService.getNewsById(news.getId());
        return new ResponseEntity(news.getId(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteNews(@PathVariable ("id") News news) throws NewsNotFoundEx{
        newsRepository.deleteById(news.getId());
    }

}
