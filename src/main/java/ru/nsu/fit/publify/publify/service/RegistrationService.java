package ru.nsu.fit.publify.publify.service;

import ru.nsu.fit.publify.publify.dto.LoginRequestDto;
import ru.nsu.fit.publify.publify.dto.OrganizationRegistrationRequestDto;

public interface RegistrationService {
    /**
     * Регистрирует организацию используя переданный запрос.
     *
     * @param registrationRequestDto запрос на регистрацию
     */
    void registerOrganization(OrganizationRegistrationRequestDto registrationRequestDto);
}
