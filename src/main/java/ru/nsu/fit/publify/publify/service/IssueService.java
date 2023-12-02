package ru.nsu.fit.publify.publify.service;

import org.springframework.web.multipart.MultipartFile;
import ru.nsu.fit.publify.publify.dto.IssueDto;
import ru.nsu.fit.publify.publify.dto.ResponseIssueDto;

import java.util.List;

public interface IssueService {
    void createJournalIssue(Long journalId, IssueDto issueDto, MultipartFile cover);

    void deleteJournalIssue(Long issueId);

    List<ResponseIssueDto> findByJournal(Long journalId);
}
