package com.example.filedemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.example.filedemo.model.Article;

@Component
@ConfigurationProperties(prefix = "fixtures")
public class FixturesProperty {
	private List<Article> articles = new ArrayList<>();

    public List<Article> getArticles() {
        return articles;
    }
}
