package com.example.test.services;

import com.example.test.models.Article;

import java.util.List;

public interface ArticlesService {
    List<Article> getAll();
    void seve(Article article);
    void updateArticle(Long id, Article article);
    void upRating(Long id);
    void downRating(Long id);
    List<Article> getBest(String category);
    void deleteById(Long articleId);
}
