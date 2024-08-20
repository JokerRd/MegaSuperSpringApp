package ru.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import ru.test.connections.Driver;
import ru.test.model.Person;
import ru.test.repository.PersonRepository;
import ru.test.repository.SimplePersonRepository;
import ru.test.service.Service2;

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
    @Scope("prototype")
    public PersonRepository personRepository(Driver driver) {
        return new SimplePersonRepository(driver, personMap());
    }


    @Bean
    public Service2 service2(ApplicationProperties applicationProperties) {
        return new Service2(applicationProperties);
    }
}
