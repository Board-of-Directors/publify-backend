package ru.nsu.fit.publify.publify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.fit.publify.publify.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    boolean existsOrganizationByName(String name);
}
