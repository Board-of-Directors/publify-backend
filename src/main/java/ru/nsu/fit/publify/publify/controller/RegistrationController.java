package ru.nsu.fit.publify.publify.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.fit.publify.publify.dto.LoginRequestDto;
import ru.nsu.fit.publify.publify.dto.OrganizationRegistrationRequestDto;
import ru.nsu.fit.publify.publify.dto.RegistrationWorkerDto;
import ru.nsu.fit.publify.publify.service.RegistrationService;
import ru.nsu.fit.publify.publify.service.SecurityService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin(allowCredentials = "true", originPatterns = {"*"})
public class RegistrationController {
    private final RegistrationService registrationService;
    private final SecurityService securityService;
    private final HttpServletRequest httpServletRequest;

    @PostMapping("registration")
    public Long registration(@RequestBody @Valid OrganizationRegistrationRequestDto registrationRequestDto) {
        return registrationService.registerOrganization(registrationRequestDto);
    }

    @PostMapping("invite")
    public void invite(
        @RequestParam Long organizationId,
        @RequestBody @Valid List<RegistrationWorkerDto> registrationWorkerDtoList
    ) {
        registrationService.inviteWorkers(organizationId, registrationWorkerDtoList);
    }

    @PostMapping("login")
    public Long login(@RequestBody @Valid LoginRequestDto loginRequestDto) {
        securityService.login(loginRequestDto, httpServletRequest);
        return registrationService.login(loginRequestDto);

    }
}
