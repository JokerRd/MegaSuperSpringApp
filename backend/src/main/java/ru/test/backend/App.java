package ru.test.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.test.backend.model.Dog;
import ru.test.backend.model.Hobby;
import ru.test.backend.model.Person;
import ru.test.backend.repository.HobbyRepository;
import ru.test.backend.repository.PersonRepository;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var context = SpringApplication.run(App.class, args);
        var repository = context.getBean(PersonRepository.class);
        var hobbyRepository = context.getBean(HobbyRepository.class);
        var person = new Person(null, "Василий", 55, null, null);
        var person2 = new Person(null, "Клавдия", 50, null, null);
        var hobby  = new Hobby(null, "Вязание", person);
        var hobby2  = new Hobby(null, "Лепка", person);
        var dog1 = new Dog(null, "Ромбик", 25, null);
        var dog2 = new Dog(null, "Шарик", 5, null);
        dog1.setPersons(List.of(person2, person));
        dog2.setPersons(List.of(person));
        person.setDogs(List.of(dog1, dog2));
        person.setHobbies(List.of(hobby, hobby2));
        person2.setDogs(List.of(dog1));
        //var hobbies = hobbyRepository.saveAll(List.of(hobby, hobby2));
        repository.save(person);
        repository.save(person2);
        var personFromRepository = repository.findById(person.getId()).orElse(null);
        System.out.println(personFromRepository);
        System.out.println(repository.findByDogs_Id(6L));
    }
}
