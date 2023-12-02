package ru.nsu.fit.publify.publify.dto;

import jakarta.validation.constraints.NotNull;

public record ArticleDto(
    @NotNull(message = "Название статьи не может быть не задано.")
    String name,
    @NotNull(message = "Описание статьи не может быть не задано.")
    String description,
    @NotNull(message = "Номер выпуска не может быть не задан.")
    Long issueId
) {
}
