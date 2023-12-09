package ru.nsu.fit.publify.publify.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nsu.fit.publify.publify.dto.ArticleDto;
import ru.nsu.fit.publify.publify.dto.ArticleItemDto;
import ru.nsu.fit.publify.publify.enums.EntityType;
import ru.nsu.fit.publify.publify.exception.EntityNotFoundException;
import ru.nsu.fit.publify.publify.mapper.ArticleMapper;
import ru.nsu.fit.publify.publify.model.Article;
import ru.nsu.fit.publify.publify.repository.ArticleItemRepository;
import ru.nsu.fit.publify.publify.repository.ArticleRepository;
import ru.nsu.fit.publify.publify.repository.IssueRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;
    private final IssueRepository issueRepository;
    private final ArticleItemRepository articleItemRepository;

    @Override
    public void createArticle(ArticleDto articleDto) {
        articleRepository.save(
            articleMapper.toModel(articleDto)
                .setIssue(issueRepository.findById(articleDto.issueId())
                    .orElseThrow(
                        () -> new EntityNotFoundException(EntityType.ISSUE, articleDto.issueId())
                    )
                )
        );

    }

    @Override
    @Transactional
    public void updateArticleItems(Long articleId, List<ArticleItemDto> articleItemDtoList) {
        Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> new EntityNotFoundException(EntityType.ARTICLE, articleId));
        var items = articleItemDtoList.stream()
            .map(itemDto -> articleMapper.toModel(itemDto, article))
            .toList();

        articleItemRepository.deleteAllByArticle(article);

        articleItemRepository.saveAll(items);


    }

    @Override
    public List<ArticleItemDto> getArticleItems(Long articleId) {
        Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> new EntityNotFoundException(EntityType.ARTICLE, articleId));
        return articleItemRepository.findAllByArticle(article).stream()
            .map(articleMapper::toDto)
            .toList();

    }
}
