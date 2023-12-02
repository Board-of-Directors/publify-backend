package ru.nsu.fit.publify.publify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.fit.publify.publify.dto.JournalDto;
import ru.nsu.fit.publify.publify.model.Journal;

import java.util.List;

public interface JournalRepository extends JpaRepository<Journal, Long> {
    List<Journal> findAllByTitleContaining(String title);
}
