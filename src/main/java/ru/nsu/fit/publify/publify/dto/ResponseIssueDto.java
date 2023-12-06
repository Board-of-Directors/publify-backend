package ru.nsu.fit.publify.publify.dto;

import lombok.Builder;

@Builder
public record ResponseIssueDto(
    Long id,
    String title,
    Integer number,
    String releaseDate,
    byte[] cover
) {
}
