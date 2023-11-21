package ru.nsu.fit.publify.publify.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrganizationRegistrationRequestDto(
    @NotNull(message = "Название организации не может быть не задано.")
    String organizationName,
    @NotNull(message = "Имя создателя организации не может быть не задано.")
    String ownerFirstName,
    @NotNull(message = "Фамилия создателя организации не может быть не задана.")
    String ownerLastName,
    @NotNull(message = "Электронная почта создателя организации не может быть не задана.")
    String ownerEmail,
    @NotNull(message = "Список работников не может быть не задан.")
    List<@Valid RegistrationWorkerDto> workerEmails
) {
}
