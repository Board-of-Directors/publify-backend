package ru.nsu.fit.publify.publify.service;

import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.fit.publify.publify.dto.EmployeeDto;
import ru.nsu.fit.publify.publify.exception.OrganizationNotFoundException;
import ru.nsu.fit.publify.publify.mapper.EmployeeMapper;
import ru.nsu.fit.publify.publify.model.Organization;
import ru.nsu.fit.publify.publify.repository.EmployeeRepository;
import ru.nsu.fit.publify.publify.repository.OrganizationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final OrganizationRepository organizationRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    @Nonnull
    public List<EmployeeDto> findEmployeesByOrganization(Long organizationId) {
        Organization organization = organizationRepository.findById(organizationId)
            .orElseThrow(() -> new OrganizationNotFoundException(organizationId));
        return employeeRepository.findEmployeeByOrganization(organization)
            .stream()
            .map(employeeMapper::toDto)
            .toList();
    }
}
