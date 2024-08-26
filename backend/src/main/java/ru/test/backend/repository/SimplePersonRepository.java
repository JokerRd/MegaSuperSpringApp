package ru.test.backend.repository;

import ru.test.backend.EntityNotFoundException;
import ru.test.backend.connections.Driver;
import ru.test.backend.model.Person;

import java.util.*;
import java.util.stream.Collectors;

//@Repository
//@Scope("prototype")
public class SimplePersonRepository implements PersonRepository {

    private final Driver driver;

    private final Map<Long, Person> personMap;

    public SimplePersonRepository(Driver driver, Map<Long, Person> personMap) {
        this.driver = driver;
        this.personMap = personMap;
    }

    @Override
    public Long save(Person person) {
        personMap.put(person.getId(), person);
        return person.getId();
    }

    @Override
    public Person read(Long id) {
        return personMap.get(id);
    }

    @Override
    public Long delete(Long id) {
        if (personMap.containsKey(id)) {
            return personMap.remove(id).getId();
        }
        throw new EntityNotFoundException();
    }

    @Override
    public List<Long> saveAll(List<Person> persons) {
        var mapForSave = persons.stream().collect(Collectors.toMap(
                Person::getId,
                forValue -> forValue
        ));
        personMap.putAll(mapForSave);
        return persons.stream().map(Person::getId).collect(Collectors.toList());
    }

    @Override
    public List<Person> getAll() {
        return new ArrayList<>(personMap.values());
    }
}
