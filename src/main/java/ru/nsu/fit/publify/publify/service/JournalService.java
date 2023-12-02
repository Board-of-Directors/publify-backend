package ru.nsu.fit.publify.publify.service;

import ru.nsu.fit.publify.publify.dto.JournalCreationRequest;
import ru.nsu.fit.publify.publify.dto.JournalDto;

import java.util.List;
import java.util.Optional;

public interface JournalService {
    void createJournal(JournalCreationRequest journalCreationRequest);

    void deleteJournal(Long journalId);

    List<JournalDto> searchJournal(String name);

    JournalDto getById(Long id);

    JournalDto changeJournal(Long id, JournalCreationRequest journalCreationRequest);
}
