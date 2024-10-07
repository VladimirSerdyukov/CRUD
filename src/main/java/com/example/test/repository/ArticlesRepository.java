package com.example.test.repository;

import com.example.test.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByCategory(String category);
}
