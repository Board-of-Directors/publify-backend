package ru.nsu.fit.publify.publify.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.fit.publify.publify.dto.ArticleDto;
import ru.nsu.fit.publify.publify.service.ArticleService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/article")
@CrossOrigin(allowCredentials = "true", originPatterns = {"*"})
public class ArticleController {
    private final ArticleService articleService;
    @PostMapping
    public void createArticle(@RequestBody ArticleDto articleDto) {
        articleService.createArticle(articleDto);
    }
}
