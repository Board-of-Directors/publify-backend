package ru.nsu.fit.publify.publify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nsu.fit.publify.publify.dto.ArticleDto;
import ru.nsu.fit.publify.publify.mapper.ArticleMapper;
import ru.nsu.fit.publify.publify.repository.ArticleRepository;
import ru.nsu.fit.publify.publify.repository.IssueRepository;

@Component
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;
    private final IssueRepository issueRepository;

    @Override
    public void createArticle(ArticleDto articleDto) {
        articleRepository.save(
            articleMapper.toModel(articleDto)
                .setIssue(issueRepository.findById(articleDto.issueId()).orElseThrow())
        );

    }
}
