package ru.nsu.fit.publify.publify.service;

import jakarta.annotation.Nonnull;
import ru.nsu.fit.publify.publify.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    @Nonnull
    List<EmployeeDto> findEmployeesByOrganization(Long organizationId);
}
