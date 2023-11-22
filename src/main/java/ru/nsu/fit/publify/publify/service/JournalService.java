package ru.nsu.fit.publify.publify.service;

import ru.nsu.fit.publify.publify.dto.JournalCreationRequest;

public interface JournalService {
    void createJournal(JournalCreationRequest journalCreationRequest);
}
