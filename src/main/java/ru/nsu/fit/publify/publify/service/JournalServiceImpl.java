package ru.nsu.fit.publify.publify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.fit.publify.publify.dto.JournalCreationRequest;
import ru.nsu.fit.publify.publify.dto.JournalDto;
import ru.nsu.fit.publify.publify.enums.EntityType;
import ru.nsu.fit.publify.publify.exception.EntityNotFoundException;
import ru.nsu.fit.publify.publify.exception.WorkerNotFoundException;
import ru.nsu.fit.publify.publify.mapper.JournalMapper;
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
    private final JournalMapper journalMapper;

    @Override
    public void createJournal(JournalCreationRequest journalCreationRequest) {
        Organization organization = organizationRepository.findById(journalCreationRequest.organizationId())
            .orElseThrow(() -> new EntityNotFoundException(EntityType.ORGANIZATION, journalCreationRequest.organizationId()));

        List<Employee> journalEditors = journalCreationRequest.employeeEmails().stream()
            .map(employeeRepository::findEmployeeByEmail)
            .map(optionalWorker -> optionalWorker.orElseThrow(WorkerNotFoundException::new))
            .toList();

        Journal journal = new Journal()
            .setTitle(journalCreationRequest.name())
            .setDescription(journalCreationRequest.description())
            .setOrganization(organization)
            .setJournalEditors(journalEditors);

        journalRepository.save(journal);

    }

    @Override
    public void deleteJournal(Long journalId) {
        journalRepository.deleteById(journalId);
    }

    @Override
    public List<JournalDto> searchJournal(String name) {
        return journalMapper.toDtoList(journalRepository.findAllByTitleContaining(name));
    }

    @Override
    public JournalDto getById(Long id) {
        Journal journal = journalRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException(EntityType.JOURNAL, id)
        );

        return journalMapper.toDto(journal);

    }

    @Override
    public JournalDto changeJournal(Long id, JournalCreationRequest journalCreationRequest) {
        getById(id);

        List<Employee> journalEditors = journalCreationRequest.employeeEmails().stream()
            .map(employeeRepository::findEmployeeByEmail)
            .map(optionalWorker -> optionalWorker.orElseThrow(WorkerNotFoundException::new))
            .toList();

        Journal journal = new Journal()
            .setId(id)
            .setTitle(journalCreationRequest.name())
            .setDescription(journalCreationRequest.description())
            .setJournalEditors(journalEditors);

        journalRepository.save(journal);

        return getById(id);
    }
}
