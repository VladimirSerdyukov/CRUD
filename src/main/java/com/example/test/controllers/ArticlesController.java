package com.example.test.controllers;

import com.example.test.models.Article;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ArticlesController {
    List<Article> getArticles();
    void createArticle(@RequestBody Article article);
    void updateArticle(@RequestBody Article article, @PathVariable Long articleId);
    void upRating(@PathVariable Long articleId);
    void downRating(@PathVariable Long articleId);
    List<Article> getBest (@RequestParam String category);

}
