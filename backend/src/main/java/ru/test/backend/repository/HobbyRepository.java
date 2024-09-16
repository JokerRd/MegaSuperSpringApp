package ru.test.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.backend.model.Hobby;
import ru.test.backend.model.Person;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
}
