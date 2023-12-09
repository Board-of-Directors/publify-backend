package ru.nsu.fit.publify.publify.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ArticleItemDto(
    Long id,
    @NotNull(message = "Контент не может быть не задан.")
    String content,
    @NotNull(message = "Тип контента не может быть не задан.")
    String contentType,
    @NotNull(message = "Порядковый номер не может быть не задан.")
    Integer sequenceNumber
) {
}
