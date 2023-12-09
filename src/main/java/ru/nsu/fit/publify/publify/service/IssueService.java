package ru.nsu.fit.publify.publify.service;

import ru.nsu.fit.publify.publify.dto.IssueDto;
import ru.nsu.fit.publify.publify.dto.ResponseIssueDto;

import java.util.List;

public interface IssueService {
    void createJournalIssue(Long journalId, IssueDto issueDto);

    void deleteJournalIssue(Long issueId);

    List<ResponseIssueDto> findByJournal(Long journalId);

    void updateIssue(Long issueId, IssueDto issueDto);
}
