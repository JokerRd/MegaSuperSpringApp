package ru.test.backend.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.test.backend.EntityNotFoundException;
import ru.test.backend.connections.Driver;
import ru.test.backend.mapper.PersonMapper;
import ru.test.backend.mapper.PersonRowMapper;
import ru.test.backend.model.Person;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class SimplePersonRepository implements PersonRepository {

    private final Driver driver;
    private final Map<Long, Person> personMap;
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsertPerson;
    private final PersonMapper personMapper;


    @Override
    public Long save(Person person) {
        Map<String, Object> parameters = personMapper.toMap(person);
        simpleJdbcInsertPerson.execute(parameters);
        return person.getId();
    }

    @Override
    public Person read(Long id) {
        return jdbcTemplate.queryForObject("select * from persons where id = ?",
                new PersonRowMapper(), id);
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
        return jdbcTemplate.query("select * from persons", new PersonRowMapper());
    }
}
