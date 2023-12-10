package ru.nsu.fit.publify.publify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.fit.publify.publify.model.Article;
import ru.nsu.fit.publify.publify.model.Issue;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByIssue(Issue issue);
}
