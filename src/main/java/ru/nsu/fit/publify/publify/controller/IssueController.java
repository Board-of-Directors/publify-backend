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
        @RequestBody @Valid IssueDto issueDto
    ) {
        issueService.createJournalIssue(journalId, issueDto);
    }

    @PutMapping
    public void change(
        @RequestParam Long issueId,
        @RequestBody @Valid IssueDto issueDto
    ) {
        issueService.updateIssue(issueId, issueDto);
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
