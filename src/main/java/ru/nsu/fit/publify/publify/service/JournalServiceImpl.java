package ru.nsu.fit.publify.publify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.fit.publify.publify.dto.JournalCreationRequest;
import ru.nsu.fit.publify.publify.exception.OrganizationNotFoundException;
import ru.nsu.fit.publify.publify.exception.WorkerNotFoundException;
import ru.nsu.fit.publify.publify.model.Employee;
import ru.nsu.fit.publify.publify.model.Journal;
import ru.nsu.fit.publify.publify.model.Organization;
import ru.nsu.fit.publify.publify.repository.EmployeeRepository;
import ru.nsu.fit.publify.publify.repository.JournalRepository;
import ru.nsu.fit.publify.publify.repository.OrganizationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {
    private final JournalRepository journalRepository;
    private final OrganizationRepository organizationRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void createJournal(JournalCreationRequest journalCreationRequest) {
        Organization organization = organizationRepository.findById(journalCreationRequest.organizationId())
            .orElseThrow(() -> new OrganizationNotFoundException(journalCreationRequest.organizationId()));

        List<Employee> journalEditors = journalCreationRequest.employeeEmails().stream()
            .map(employeeRepository::findEmployeeByEmail)
            .map(optionalWorker -> optionalWorker.orElseThrow(WorkerNotFoundException::new))
            .toList();

        Journal journal = new Journal()
            .setTitle(journalCreationRequest.title())
            .setDescription(journalCreationRequest.description())
            .setOrganization(organization)
            .setJournalEditors(journalEditors);

        journalRepository.save(journal);

    }

    @Override
    public void deleteJournal(Long journalId) {
        journalRepository.deleteById(journalId);
    }
}
