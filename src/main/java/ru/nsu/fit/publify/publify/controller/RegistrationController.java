package ru.nsu.fit.publify.publify.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.fit.publify.publify.dto.LoginRequestDto;
import ru.nsu.fit.publify.publify.dto.OrganizationRegistrationRequestDto;
import ru.nsu.fit.publify.publify.service.RegistrationService;
import ru.nsu.fit.publify.publify.service.SecurityService;

@RestController
@RequiredArgsConstructor
@Validated
public class RegistrationController {
    private final RegistrationService registrationService;
    private final SecurityService securityService;
    private final HttpServletRequest httpServletRequest;

    @PostMapping("registration")
    public void registration(@RequestBody @Valid OrganizationRegistrationRequestDto registrationRequestDto) {
        registrationService.registerOrganization(registrationRequestDto);
    }

    @PostMapping("login")
    public void login(@RequestBody @Valid LoginRequestDto loginRequestDto) {
        securityService.login(loginRequestDto, httpServletRequest);

    }
}
