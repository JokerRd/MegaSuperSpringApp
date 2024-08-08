package ru.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.test.repository.PersonRepository;
import ru.test.service.*;

@SpringBootApplication
public class App {

    public static void main( String[] args ) {
        var context = SpringApplication.run(App.class, args);
        var personRepository = context.getBean(PersonRepository.class);
        var personRepository2 = context.getBean(PersonRepository.class);
        var personRepository3 = context.getBean(PersonRepository.class);
        System.out.println(personRepository == personRepository2);
        System.out.println(personRepository == personRepository3);
        System.out.println(personRepository2 == personRepository3);

        var service3 = context.getBean(Service3.class);
        var service4 = context.getBean(Service4.class);
        System.out.println(service4.getPersonRepository() == service3.getPersonRepository());
//        var result = personService.registerPerson(new PersonInfo("Влад", 18, LocalDate.now()));
//        System.out.println(result);
    }


}
