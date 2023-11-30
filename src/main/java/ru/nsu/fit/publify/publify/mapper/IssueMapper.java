package ru.nsu.fit.publify.publify.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.nsu.fit.publify.publify.dto.IssueDto;
import ru.nsu.fit.publify.publify.model.Issue;
import ru.nsu.fit.publify.publify.model.Journal;
import ru.nsu.fit.publify.publify.service.ImageService;

import java.sql.Date;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class IssueMapper {
    private final ImageService imageService;

    public Issue toModel(IssueDto issueDto, MultipartFile cover, Journal journal) {
        return new Issue().setName(issueDto.name())
            .setDescription(issueDto.description())
            .setReleaseDate(Date.valueOf(issueDto.releaseDate().orElse(LocalDate.now())))
            .setNumber(issueDto.number())
            .setCover(imageService.save(cover))
            .setJournal(journal);

    }
}