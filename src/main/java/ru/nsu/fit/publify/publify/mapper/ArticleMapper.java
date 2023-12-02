package ru.nsu.fit.publify.publify.mapper;

import org.springframework.stereotype.Component;
import ru.nsu.fit.publify.publify.dto.ArticleDto;
import ru.nsu.fit.publify.publify.model.Article;

@Component
public class ArticleMapper {
    public Article toModel(ArticleDto articleDto) {
        return new Article()
            .setName(articleDto.name())
            .setDescription(articleDto.description());

    }
}
