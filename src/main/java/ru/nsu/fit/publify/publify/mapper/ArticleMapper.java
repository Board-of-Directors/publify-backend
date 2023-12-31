package ru.nsu.fit.publify.publify.mapper;

import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Component;
import ru.nsu.fit.publify.publify.dto.ArticleDto;
import ru.nsu.fit.publify.publify.dto.ArticleItemDto;
import ru.nsu.fit.publify.publify.dto.ResponseArticleDto;
import ru.nsu.fit.publify.publify.enums.ContentType;
import ru.nsu.fit.publify.publify.model.Article;
import ru.nsu.fit.publify.publify.model.ArticleItem;

@Component
public class ArticleMapper {

    @Nonnull
    public Article toModel(ArticleDto articleDto) {
        return new Article()
            .setName(articleDto.name())
            .setDescription(articleDto.description());

    }

    @Nonnull
    public ArticleItem toModel(ArticleItemDto itemDto, Article article) {
        return new ArticleItem()
            .setContent(itemDto.content())
            .setContentType(ContentType.fromString(itemDto.contentType()))
            .setSequenceNumber(itemDto.sequenceNumber())
            .setArticle(article);
    }

    @Nonnull
    public ArticleItemDto toDto(ArticleItem articleItem) {
        return ArticleItemDto.builder()
            .id(articleItem.getId())
            .content(articleItem.getContent())
            .contentType(articleItem.getContentType().name())
            .sequenceNumber(articleItem.getSequenceNumber())
            .build();
    }

    @Nonnull
    public ResponseArticleDto toDto(Article article) {
        return ResponseArticleDto.builder()
            .id(article.getId())
            .name(article.getName())
            .description(article.getDescription())
            .textBlocksCount(getItemCountByType(article, ContentType.TEXT))
            .illustrationBlocksCount(getItemCountByType(article, ContentType.IMAGE))
            .build();
    }

    private long getItemCountByType(Article article, ContentType contentType) {
        return article.getArticleItem().stream()
            .filter(item -> item.getContentType() == contentType)
            .count();

    }
}
