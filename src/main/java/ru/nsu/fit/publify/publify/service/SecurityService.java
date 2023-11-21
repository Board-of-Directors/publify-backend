package ru.nsu.fit.publify.publify.service;

import jakarta.servlet.http.HttpServletRequest;
import ru.nsu.fit.publify.publify.dto.LoginRequestDto;
import ru.nsu.fit.publify.publify.model.Employee;

public interface SecurityService {
    Employee getLoggedInUser();

    void login(LoginRequestDto loginRequestDto, HttpServletRequest request);
}
