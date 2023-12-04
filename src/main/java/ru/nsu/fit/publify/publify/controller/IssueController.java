package ru.nsu.fit.publify.publify.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.nsu.fit.publify.publify.dto.IssueDto;
import ru.nsu.fit.publify.publify.dto.ResponseIssueDto;
import ru.nsu.fit.publify.publify.service.IssueService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/issue")
@CrossOrigin(allowCredentials = "true", originPatterns = {"*"})
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

    @GetMapping(value = "search")
    public List<ResponseIssueDto> search(@RequestParam Long journalId) {
        return issueService.findByJournal(journalId);
    }
}
