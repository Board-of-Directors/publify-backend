package ru.nsu.fit.publify.publify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.nsu.fit.publify.publify.dto.IssueDto;
import ru.nsu.fit.publify.publify.exception.JournalNotFoundException;
import ru.nsu.fit.publify.publify.mapper.IssueMapper;
import ru.nsu.fit.publify.publify.model.Journal;
import ru.nsu.fit.publify.publify.repository.IssueRepository;
import ru.nsu.fit.publify.publify.repository.JournalRepository;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;
    private final JournalRepository journalRepository;
    private final IssueMapper issueMapper;

    @Override
    public void createJournalIssue(Long journalId, IssueDto issueDto, MultipartFile cover) {
        Journal journal = journalRepository.findById(journalId).orElseThrow(
            () -> new JournalNotFoundException(journalId)
        );
        issueRepository.save(issueMapper.toModel(issueDto, cover, journal));
    }

    @Override
    public void deleteJournalIssue(Long issueId) {
        issueRepository.deleteById(issueId);
    }
}
