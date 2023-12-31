package ru.nsu.fit.publify.publify.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record JournalDto(
    Long id,
    String name,
    List<String> employeeEmails,
    Integer issueCount,
    Integer workerCount,
    String description
) {
}
