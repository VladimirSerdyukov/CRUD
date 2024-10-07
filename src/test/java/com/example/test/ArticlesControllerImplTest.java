package com.example.test;

import com.example.test.models.Article;
import com.example.test.repository.ArticlesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticlesControllerImplTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ArticlesRepository articlesRepository;

    @Test
    public void getBestTest() throws URISyntaxException {
        articlesRepository.deleteAll();

        // given
        String category = "String1";
        articlesRepository.save(new Article(1L, "String1", "String1", "String1", 4));
        articlesRepository.save(new Article(2L, "String1", "String2", "String1", 6));
        articlesRepository.save(new Article(3L, "String1", "String3", "String1", -1));
        articlesRepository.save(new Article(4L, "String1", "String4", "String1", 0));
        articlesRepository.save(new Article(5L, "String1", "String4", "String4", 2));

        // when

        ResponseEntity<List<Article>> responseEntity = restTemplate.
                exchange(new RequestEntity<>(HttpMethod.GET,
                        new URI("/articles/best?category=" + category)),
                        new ParameterizedTypeReference<List<Article>>() {});

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Article> response = responseEntity.getBody();
        Assertions.assertEquals(2, response.size());
        Assertions.assertEquals("String2", response.get(0).getDescription());
    }
}
