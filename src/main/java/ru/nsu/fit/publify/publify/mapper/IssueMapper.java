package ru.nsu.fit.publify.publify.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nsu.fit.publify.publify.dto.IssueDto;
import ru.nsu.fit.publify.publify.dto.ResponseIssueDto;
import ru.nsu.fit.publify.publify.model.Issue;
import ru.nsu.fit.publify.publify.model.Journal;
import ru.nsu.fit.publify.publify.service.ImageService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class IssueMapper {
    private final ImageService imageService;

    public Issue toModel(IssueDto issueDto, Journal journal) {
        return new Issue().setName(issueDto.name())
            .setDescription(issueDto.description())
            .setReleaseDate(Date.valueOf(issueDto.releaseDate().orElse(LocalDate.now())))
            .setNumber(issueDto.number())
            .setCover(imageService.save(issueDto.cover(), journal.getTitle(), issueDto.number()))
            .setJournal(journal);

    }

    public List<ResponseIssueDto> toDtoList(List<Issue> issues) {
        return issues.stream()
            .map(this::toDto)
            .toList();
    }

    public ResponseIssueDto toDto(Issue issue) {
        return ResponseIssueDto.builder()
            .id(issue.getId())
            .title(issue.getName())
            .number(issue.getNumber())
            .releaseDate(issue.getReleaseDate().toString())
            .cover(imageService.load(issue.getCover()))
            .build();
    }
}
