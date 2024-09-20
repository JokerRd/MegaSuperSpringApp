package ru.test.backend.cache;

import org.springframework.stereotype.Component;
import ru.test.backend.model.Person;

import java.util.HashMap;
import java.util.Map;

@Component
public class PersonCache implements Cache<Person> {

    Map<Long, Person> cache = new HashMap<>();

    @Override
    public void put(Long id, Person value) {
        cache.put(id, value);
    }

    @Override
    public Person get(Long id) {
        return cache.get(id);
    }

    @Override
    public void invalidate(Long id) {
        cache.remove(id);
    }

}
