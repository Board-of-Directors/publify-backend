package ru.nsu.fit.publify.publify.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record JournalCreationRequest(
    @NotNull(message = "Название журнала не может не задано.")
    String title,
    @NotNull(message = "Описание журнала не может не задано.")
    String description,
    @NotNull(message = "Идентификатор организации не может быть не задан.")
    Long organizationId,
    @NotNull(message = "Список сотрудников не может быть не задан.")
    List<String> employeeEmails

) {
}
