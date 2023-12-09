package ru.nsu.fit.publify.publify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.fit.publify.publify.model.Article;
import ru.nsu.fit.publify.publify.model.ArticleItem;

import java.util.List;

public interface ArticleItemRepository extends JpaRepository<ArticleItem, Long> {
    List<ArticleItem> findAllByArticle(Article article);

    void deleteAllByArticle(Article article);
}
