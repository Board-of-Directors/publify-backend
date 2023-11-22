package ru.nsu.fit.publify.publify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.fit.publify.publify.model.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}
