package com.example.newsblog;

import com.example.newsblog.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Map<String, User> auth() {
        return new LinkedHashMap<>();
    }

    @Bean
    public Map<Long, String> tokens() {
        return new HashMap<>();
    }
}
