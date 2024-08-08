package ru.test.service;

import org.springframework.stereotype.Service;
import ru.test.repository.PersonRepository;

@Service
public class Service4 {

    private final PersonRepository personRepository;

    public Service4(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

}
