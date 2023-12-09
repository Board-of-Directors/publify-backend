package ru.nsu.fit.publify.publify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.fit.publify.publify.dto.IssueDto;
import ru.nsu.fit.publify.publify.dto.ResponseIssueDto;
import ru.nsu.fit.publify.publify.enums.EntityType;
import ru.nsu.fit.publify.publify.exception.EntityNotFoundException;
import ru.nsu.fit.publify.publify.mapper.IssueMapper;
import ru.nsu.fit.publify.publify.model.Issue;
import ru.nsu.fit.publify.publify.model.Journal;
import ru.nsu.fit.publify.publify.repository.IssueRepository;
import ru.nsu.fit.publify.publify.repository.JournalRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;
    private final JournalRepository journalRepository;
    private final IssueMapper issueMapper;

    @Override
    public void createJournalIssue(Long journalId, IssueDto issueDto) {
        Journal journal = journalRepository.findById(journalId).orElseThrow(
            () -> new EntityNotFoundException(EntityType.JOURNAL, journalId)
        );
        issueRepository.save(issueMapper.toModel(issueDto, journal));
    }

    @Override
    public void deleteJournalIssue(Long issueId) {
        issueRepository.deleteById(issueId);
    }

    @Override
    public List<ResponseIssueDto> findByJournal(Long journalId) {
        Journal journal = journalRepository.findById(journalId).orElseThrow(
            () -> new EntityNotFoundException(EntityType.JOURNAL, journalId)
        );
        return issueMapper.toDtoList(issueRepository.findAllByJournal(journal));
    }

    @Override
    public void updateIssue(Long issueId, IssueDto issueDto) {
        Issue issue = issueRepository.findById(issueId)
            .orElseThrow(() -> new EntityNotFoundException(EntityType.ISSUE, issueId));

        issueRepository.save(
            issueMapper.toModel(issueDto, issue.getJournal())
                .setId(issue.getId())
        );
    }
}
