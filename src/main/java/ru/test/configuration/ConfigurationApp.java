package ru.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.test.connections.Driver;
import ru.test.model.Person;
import ru.test.repository.PersonRepository;
import ru.test.repository.SimplePersonRepository;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigurationApp {

    @Bean
    public Map<Long, Person> personMap() {
        System.out.println("personMap");
        return new HashMap<>();
    }

    @Bean
    @Scope("prototype")
    public PersonRepository personRepository(Driver driver) {
        return new SimplePersonRepository(driver, personMap());
    }

}
