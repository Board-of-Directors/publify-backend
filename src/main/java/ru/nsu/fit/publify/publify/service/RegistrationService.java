package ru.nsu.fit.publify.publify.service;

import ru.nsu.fit.publify.publify.dto.OrganizationRegistrationRequestDto;
import ru.nsu.fit.publify.publify.dto.RegistrationWorkerDto;

import java.util.List;

public interface RegistrationService {
    /**
     * Регистрирует организацию используя переданный запрос.
     *
     * @param registrationRequestDto запрос на регистрацию
     */
    Long registerOrganization(OrganizationRegistrationRequestDto registrationRequestDto);

    void inviteWorkers(Long organizationId, List<RegistrationWorkerDto> registrationWorkerDtoList);
}
