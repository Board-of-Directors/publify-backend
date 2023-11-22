package ru.nsu.fit.publify.publify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.fit.publify.publify.model.Employee;
import ru.nsu.fit.publify.publify.model.Organization;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsEmployeeByEmail(String email);

    Optional<Employee> findEmployeeByEmail(String email);

    List<Employee> findEmployeeByOrganization(Organization organization);
}
