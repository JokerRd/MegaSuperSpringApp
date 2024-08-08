package ru.test.repository;

import ru.test.model.Person;

import java.util.List;

public interface PersonRepository {

    Long save(Person person);
    Person read(Long id);
    Long delete(Long id);
    List<Long> saveAll(List<Person> persons);
    List<Person> getAll();
}
