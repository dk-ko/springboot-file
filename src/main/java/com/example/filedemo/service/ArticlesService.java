package com.example.filedemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.filedemo.model.Article;
import com.example.filedemo.repository.FixturesProperty;

@Service
public class ArticlesService {
	@Autowired
    FixturesProperty fixturesProperty;

    public List<Article> getArticles() {
        List<Article> articles = new ArrayList<>(fixturesProperty.getArticles());
        return articles;
    }

    public Article getArticle(long id) {
        List<Article> articles = this.getArticles();
        Article article = articles.stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList()).get(0);
        return article;
    }

    public List<Article> deleteArticle(long id) {
        List<Article> articles = this.getArticles();
        articles.removeIf(p -> p.getId() == id);
        return articles;
    }
}
