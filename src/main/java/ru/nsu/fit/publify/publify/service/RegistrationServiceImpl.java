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
import ru.nsu.fit.publify.publify.exception.OrganizationNotFoundException;
import ru.nsu.fit.publify.publify.mapper.EmployeeMapper;
import ru.nsu.fit.publify.publify.model.Employee;
import ru.nsu.fit.publify.publify.model.Organization;
import ru.nsu.fit.publify.publify.repository.EmployeeRepository;
import ru.nsu.fit.publify.publify.repository.OrganizationRepository;

import java.util.List;

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
    public Long registerOrganization(OrganizationRegistrationRequestDto registrationRequestDto) {
        validate(registrationRequestDto);
        Organization organization = new Organization().setName(registrationRequestDto.organizationName());
        organization = organizationRepository.save(organization);

        Employee owner = employeeMapper.toOwner(registrationRequestDto, organization);
        sendEmailAndSave(owner);

        return organization.getId();
    }

    @Override
    public void inviteWorkers(Long organizationId, List<RegistrationWorkerDto> registrationWorkerDtoList) {
        Organization organization = organizationRepository.findById(organizationId)
            .orElseThrow(() -> new OrganizationNotFoundException(organizationId));

        registrationWorkerDtoList.stream()
            .map(workerDto -> employeeMapper.toWorker(workerDto, organization))
            .forEachOrdered(this::sendEmailAndSave);
    }

    private void sendEmailAndSave(Employee employee) {
        String decodedPassword = employee.getPassword();
        employeeRepository.save(
            employee.setPassword(passwordEncoder.encode(decodedPassword))
        );
        employeeMailSenderService.sendRegistrationEmail(employee.getEmail(), decodedPassword);
    }

    private void validate(OrganizationRegistrationRequestDto registrationRequestDto) {
        if (
            organizationRepository.existsOrganizationByName(registrationRequestDto.organizationName())
                || employeeRepository.existsEmployeeByEmail(registrationRequestDto.ownerEmail())
        ) {
            throw new AlreadyRegisteredException();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return employeeRepository.findEmployeeByEmail(login).orElseThrow(RuntimeException::new);
    }
}
