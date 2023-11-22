package ru.nsu.fit.publify.publify.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.fit.publify.publify.dto.JournalCreationRequest;
import ru.nsu.fit.publify.publify.service.JournalService;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "journal")
public class JournalController {
    private final JournalService journalService;

    @PostMapping
    public void create(@RequestBody @Valid JournalCreationRequest journalCreationRequest) {
        journalService.createJournal(journalCreationRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long journalId){
        journalService.deleteJournal(journalId);
    }
}
