package ru.nsu.fit.publify.publify.dto;

import jakarta.validation.constraints.NotNull;

public record LoginRequestDto(
    @NotNull(message = "Логин пользователя не может отсутствовать.")
    String login,
    @NotNull(message = "Пароль пользователя не может отсутствовать.")
    String password
) {
}
