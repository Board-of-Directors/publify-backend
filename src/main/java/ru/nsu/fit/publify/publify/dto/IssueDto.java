package ru.nsu.fit.publify.publify.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Optional;

public record IssueDto(
    @NotNull(message = "Название выпуска не может отсутствовать.")
    String name,
    @NotNull(message = "Описание выпуска не может отсутствовать.")
    String description,
    @NotNull(message = "Номер выпуска не может быть не задан.")
    Integer number,
    Optional<LocalDate> releaseDate
) {
}
