package com.example.newsblog.repositiries;

import com.example.newsblog.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long>{
}
