package com.example.test.controllers;

import com.example.test.models.Article;
import com.example.test.services.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticlesControllerImpl implements ArticlesController{

    private ArticlesService articlesService;
    @Autowired
    public ArticlesControllerImpl(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    @GetMapping
    public List<Article> getArticles(){
        return articlesService.getAll();
    }

    @PostMapping()
    public void createArticle(@RequestBody Article article) {
        articlesService.seve(article);
    }

    @PostMapping("/{articleId}")
    public void updateArticle(@RequestBody Article article, @PathVariable Long articleId) {
        articlesService.updateArticle(articleId, article);
    }

    @PostMapping("/{articleId}/rating/up")
    public void upRating(@PathVariable Long articleId){
        articlesService.upRating(articleId);
    }

    @PostMapping("/{articleId}/rating/down")
    public void downRating(@PathVariable Long articleId){
        articlesService.downRating(articleId);
    }

    @GetMapping("/best")
    public List<Article> getBest (@RequestParam String category) {
        return articlesService.getBest(category);
    }

    @DeleteMapping("/{articleId}/delete")
    public void deleteById(@PathVariable Long articleId){
        articlesService.deleteById(articleId);
    }
}
