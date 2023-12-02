package ru.nsu.fit.publify.publify.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.fit.publify.publify.dto.JournalCreationRequest;
import ru.nsu.fit.publify.publify.dto.JournalDto;
import ru.nsu.fit.publify.publify.service.JournalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "journal")
public class JournalController {
    private final JournalService journalService;

    @PostMapping
    public void create(@RequestBody @Valid JournalCreationRequest journalCreationRequest) {
        journalService.createJournal(journalCreationRequest);
    }

    @GetMapping(name = "/search")
    public List<JournalDto> search(@RequestParam Optional<String> name) {
        return journalService.searchJournal(name.orElse(StringUtils.EMPTY));
    }

    @PutMapping
    public JournalDto change(
        @RequestParam Long id,
        @RequestBody JournalCreationRequest journalCreationRequest
    ) {
        return journalService.changeJournal(id, journalCreationRequest);
    }


    @GetMapping
    public JournalDto get(@RequestParam Long id) {
        return journalService.getById(id);
    }

    @DeleteMapping
    public void delete(@RequestParam Long journalId) {
        journalService.deleteJournal(journalId);
    }
}
