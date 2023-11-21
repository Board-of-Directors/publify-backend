package ru.nsu.fit.publify.publify.dto;

import jakarta.validation.constraints.NotNull;

public record RegistrationWorkerDto(
    @NotNull(message = "Роль работника не может быть не задана.")
    String role,
    @NotNull(message = "Электронная почта работника не может быть не задана")
    String email
) {
}
