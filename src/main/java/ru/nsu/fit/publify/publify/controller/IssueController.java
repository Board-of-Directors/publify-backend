package ru.nsu.fit.publify.publify.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.nsu.fit.publify.publify.dto.IssueDto;
import ru.nsu.fit.publify.publify.service.IssueService;

@RestController
@RequiredArgsConstructor
@RequestMapping("issue")
public class IssueController {
    private final IssueService issueService;

    @PostMapping
    public void create(
        @RequestParam Long journalId,
        @RequestBody IssueDto issueDto,
        @RequestPart MultipartFile cover
    ) {
        issueService.createJournalIssue(journalId, issueDto, cover);
    }

    @DeleteMapping
    public void delete(@RequestParam Long issueId) {
        issueService.deleteJournalIssue(issueId);
    }
}