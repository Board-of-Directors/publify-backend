package ru.nsu.fit.publify.publify.service;

import ru.nsu.fit.publify.publify.dto.ArticleDto;
import ru.nsu.fit.publify.publify.dto.ArticleItemDto;
import ru.nsu.fit.publify.publify.dto.ResponseArticleDto;

import java.util.List;

public interface ArticleService {
    void createArticle(ArticleDto articleDto);

    void updateArticleItems(Long articleId, List<ArticleItemDto> articleItemDtoList);

    List<ArticleItemDto> getArticleItems(Long articleId);

    ResponseArticleDto getArticle(Long articleId);

    void deleteArticle(Long articleId);

    List<ResponseArticleDto> searchByIssueId(Long issueId);
}
