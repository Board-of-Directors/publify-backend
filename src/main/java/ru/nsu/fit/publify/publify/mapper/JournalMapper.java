package ru.nsu.fit.publify.publify.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nsu.fit.publify.publify.dto.JournalDto;
import ru.nsu.fit.publify.publify.model.Employee;
import ru.nsu.fit.publify.publify.model.Journal;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JournalMapper {

    public JournalDto toDto(Journal journal) {
        return JournalDto.builder()
            .id(journal.getId())
            .name(journal.getTitle())
            .description(journal.getDescription())
            .issueCount(journal.getJournalIssues().size())
            .employeeEmails(journal.getJournalEditors().stream().map(Employee::getEmail).toList())
            .workerCount(journal.getJournalEditors().size())
            .build();
    }

    public List<JournalDto> toDtoList(List<Journal> journalList) {
        return journalList.stream()
            .map(this::toDto)
            .toList();
    }
}
