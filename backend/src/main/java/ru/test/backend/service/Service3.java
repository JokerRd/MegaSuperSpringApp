package ru.test.backend.service;

import org.springframework.stereotype.Service;
import ru.test.backend.repository.PersonRepository;

@Service
public class Service3 {

    private final PersonRepository personRepository;

    public Service3(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }
}
