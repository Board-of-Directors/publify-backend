package ru.nsu.fit.publify.publify.dto;

import lombok.Builder;

@Builder
public record JournalDto(
    Long id,
    String name,
    Integer issueCount,
    Integer workerCount
) {
}
