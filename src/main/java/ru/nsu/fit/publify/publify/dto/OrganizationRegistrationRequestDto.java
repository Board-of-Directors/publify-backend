package ru.nsu.fit.publify.publify.dto;

import jakarta.validation.constraints.NotNull;

public record OrganizationRegistrationRequestDto(
    @NotNull(message = "Название организации не может быть не задано.")
    String organizationName,
    @NotNull(message = "Имя создателя организации не может быть не задано.")
    String ownerFirstName,
    @NotNull(message = "Фамилия создателя организации не может быть не задана.")
    String ownerLastName,
    @NotNull(message = "Пароль создателя не может быть не задан.")
    String ownerPassword,
    @NotNull(message = "Электронная почта создателя организации не может быть не задана.")
    String ownerEmail
) {
}
