package ru.nsu.fit.publify.publify.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nsu.fit.publify.publify.dto.JournalDto;
import ru.nsu.fit.publify.publify.model.Journal;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JournalMapper {

    public JournalDto toDto(Journal journal) {
        return JournalDto.builder()
            .id(journal.getId())
            .name(journal.getTitle())
            .issueCount(journal.getJournalIssues().size())
            .workerCount(journal.getJournalEditors().size())
            .build();
    }

    public List<JournalDto> toDtoList(List<Journal> journalList) {
        return journalList.stream()
            .map(this::toDto)
            .toList();
    }
}
