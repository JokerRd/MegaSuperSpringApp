package ru.test.backend.repository;

import ru.test.backend.model.Person;

import java.util.List;

public interface PersonRepository {

    Long save(Person person);
    Person read(Long id);
    Long delete(Long id);
    List<Long> saveAll(List<Person> persons);
    List<Person> getAll();
}
