package ru.test.backend.cache;

import org.springframework.stereotype.Component;
import ru.test.backend.model.Person;

@Component
public class PersonCache implements Cache<Person> {

    @Override
    public void put(Long id, Person value) {

    }

    @Override
    public Person get(Long id) {
        return null;
    }

    @Override
    public void invalidate(Long id) {

    }

}
