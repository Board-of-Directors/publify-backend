package ru.nsu.fit.publify.publify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.fit.publify.publify.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
