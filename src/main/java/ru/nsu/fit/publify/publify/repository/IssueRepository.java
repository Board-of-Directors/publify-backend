package ru.nsu.fit.publify.publify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.fit.publify.publify.model.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
