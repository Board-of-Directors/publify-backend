package ru.nsu.fit.publify.publify.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nsu.fit.publify.publify.dto.OrganizationRegistrationRequestDto;
import ru.nsu.fit.publify.publify.dto.RegistrationWorkerDto;
import ru.nsu.fit.publify.publify.exception.AlreadyRegisteredException;
import ru.nsu.fit.publify.publify.mapper.EmployeeMapper;
import ru.nsu.fit.publify.publify.model.Employee;
import ru.nsu.fit.publify.publify.model.Organization;
import ru.nsu.fit.publify.publify.repository.EmployeeRepository;
import ru.nsu.fit.publify.publify.repository.OrganizationRepository;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationServiceImpl implements RegistrationService, UserDetailsService {
    private final OrganizationRepository organizationRepository;
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;
    private final EmployeeMailSenderService employeeMailSenderService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerOrganization(OrganizationRegistrationRequestDto registrationRequestDto) {
        validate(registrationRequestDto);
        Organization organization = new Organization().setName(registrationRequestDto.organizationName());
        organizationRepository.save(organization);

        Employee owner = employeeMapper.toOwner(registrationRequestDto, organization);
        Stream<Employee> workers = registrationRequestDto.workerEmails().stream()
            .map(worker -> employeeMapper.toWorker(worker, organization));
        List<Employee> employees = Stream.concat(Stream.of(owner), workers).toList();
        encodePasswordAndSave(employees);
        employees.forEach(employeeMailSenderService::sendRegistrationEmail);
    }

    private void encodePasswordAndSave(List<Employee> employees) {
        List<Employee> employeesEncodedPasswords = List.copyOf(employees).stream()
            .map(employee -> employee.setPassword(passwordEncoder.encode(employee.getPassword())))
            .toList();
        employeeRepository.saveAll(employeesEncodedPasswords);
    }

    private void validate(OrganizationRegistrationRequestDto registrationRequestDto) {
        if (
            organizationRepository.existsOrganizationByName(registrationRequestDto.organizationName())
                || employeeRepository.existsEmployeeByEmail(registrationRequestDto.ownerEmail())
                || registrationRequestDto.workerEmails().stream()
                .map(RegistrationWorkerDto::email)
                .anyMatch(employeeRepository::existsEmployeeByEmail)
        ) {
            throw new AlreadyRegisteredException();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return employeeRepository.findEmployeeByEmail(login).orElseThrow(RuntimeException::new);
    }
}
