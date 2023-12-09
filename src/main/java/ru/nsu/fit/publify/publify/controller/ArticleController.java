package ru.nsu.fit.publify.publify.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.fit.publify.publify.dto.ArticleDto;
import ru.nsu.fit.publify.publify.dto.ArticleItemDto;
import ru.nsu.fit.publify.publify.dto.ResponseArticleDto;
import ru.nsu.fit.publify.publify.service.ArticleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/article")
@CrossOrigin(allowCredentials = "true", originPatterns = {"*"})
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping(value = "/items")
    public List<ArticleItemDto> getArticleItems(
        @RequestParam Long articleId
    ) {
        return articleService.getArticleItems(articleId);
    }

    @PostMapping
    public void createArticle(@RequestBody @Valid ArticleDto articleDto) {
        articleService.createArticle(articleDto);
    }

    @DeleteMapping
    public void deleteArticle(@RequestParam Long articleId) {
        articleService.deleteArticle(articleId);
    }

    @GetMapping
    public ResponseArticleDto get(@RequestParam Long articleId){
        return articleService.getArticle(articleId);
    }

    @PutMapping(value = "/items")
    public void updateArticleItems(
        @RequestParam Long articleId,
        @RequestBody @Valid List<ArticleItemDto> articleItemDtoList
    ) {
        articleService.updateArticleItems(articleId, articleItemDtoList);
    }
}
