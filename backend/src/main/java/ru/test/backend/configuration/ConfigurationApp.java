package ru.test.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ru.test.backend.connections.Driver;
import ru.test.backend.model.Person;
import ru.test.backend.repository.PersonRepository;
import ru.test.backend.repository.SimplePersonRepository;
import ru.test.backend.service.Service2;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigurationApp {


    @Bean
    public Map<Long, Person> personMap() {
        System.out.println("personMap");
        Map<Long, Person> map = new HashMap<>();
        map.put(1L, new Person(1L, "Федор", 17));
        return map;
    }


    @Bean
    public Service2 service2(ApplicationProperties applicationProperties) {
        return new Service2(applicationProperties);
    }

    @Bean
    public SimpleJdbcInsert simpleJdbcInsertPerson(JdbcTemplate jdbcTemplate) {
        return new SimpleJdbcInsert(jdbcTemplate).withTableName("persons");
    }
}
