package ru.nsu.fit.publify.publify.dto;

import lombok.Builder;

@Builder
public record ResponseArticleDto(
    Long id,
    String name,
    String description,
    Long textBlocksCount,
    Long illustrationBlocksCount
) {
}
