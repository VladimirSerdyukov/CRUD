package com.example.test.services;

import com.example.test.exception.ArticleNotFoundException;
import com.example.test.models.Article;
import com.example.test.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ArticlesServiceImpl implements ArticlesService{

    private ArticlesRepository articlesRepository;
    @Autowired
    public ArticlesServiceImpl(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    public List<Article> getAll(){
        return articlesRepository.findAll();
    }

    public void seve(Article article) {
        articlesRepository.save(article);
    }

    public void updateArticle(Long id, Article article) {
        article.setId(id);
        articlesRepository.save(article);
    }

    public void upRating(Long id) {
        Article article = articlesRepository.findById(id).orElseThrow(ArticleNotFoundException::new);
        article.setRating(article.getRating() + 1);
        articlesRepository.save(article);
    }

    public void downRating(Long id) {
        Article article = articlesRepository.findById(id).orElseThrow(ArticleNotFoundException::new);
        article.setRating(article.getRating() - 1);
        articlesRepository.save(article);
    }

    public List<Article> getBest(String category) {
        List<Article> articles = articlesRepository.findAllByCategory(category);
        return articles.stream().filter(article -> article.getRating() > 0)
                .sorted(Comparator.comparing(Article::getRating).reversed())
                .toList();
    }

    public void deleteById(Long articleId){
        articlesRepository.deleteById(articleId);
    }
}
