package com.example.test;

/*
 * Реализовать REST-api, по которому можно добавлять, редактировать и получать статьи.
 * Должна быть возможность увеличить или уменьшить рейтиг статьи, и получить
 * список статей по конкретной категории, упорядоченный по рейтингу.
 *
 * Для реализации используйте Spring boot
 *
 * - сущьность - статья
 * - CRUD - над статьёй GET/articles POST/articles PUT(POST)/article{id}
 * - endpoint на изменение рейтинга статьи POST/articles/{id}/rating/up POST/articles/{id}/rating/down
 * - endpoint на получение списка статей по конкретной категории, упорядоченный GET/articles/best?category=Спорт
 * Статья {
 *   category
 *   rating
 *   title
 *   text
 *   }
 * */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
}
