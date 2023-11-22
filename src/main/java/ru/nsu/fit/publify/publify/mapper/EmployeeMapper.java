package ru.nsu.fit.publify.publify.mapper;

import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ru.nsu.fit.publify.publify.dto.EmployeeDto;
import ru.nsu.fit.publify.publify.dto.OrganizationRegistrationRequestDto;
import ru.nsu.fit.publify.publify.dto.RegistrationWorkerDto;
import ru.nsu.fit.publify.publify.enums.EmployeeRole;
import ru.nsu.fit.publify.publify.model.Employee;
import ru.nsu.fit.publify.publify.model.Organization;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    @Nonnull
    public Employee toOwner(OrganizationRegistrationRequestDto registrationRequestDto, Organization organization) {
        return new Employee()
            .setName(generateFullName(registrationRequestDto.ownerFirstName(), registrationRequestDto.ownerLastName()))
            .setEmail(registrationRequestDto.ownerEmail())
            .setPassword(generatePassword())
            .setEmployeeRole(EmployeeRole.OWNER)
            .setOrganization(organization);
    }

    @Nonnull
    public Employee toWorker(RegistrationWorkerDto workerDto, Organization organization) {
        return new Employee().setEmail(workerDto.email())
            .setEmployeeRole(EmployeeRole.fromString(workerDto.role()))
            .setPassword(generatePassword())
            .setOrganization(organization);
    }

    @Nonnull
    public EmployeeDto toDto(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getEmail());
    }

    @Nonnull
    public String generatePassword() {
        return RandomStringUtils.random(12, true, true);
    }

    @Nonnull
    private String generateFullName(String firstName, String lastName) {
        return String.join(StringUtils.SPACE, firstName, lastName);
    }
}
