package ru.test.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.backend.model.Dog;
import ru.test.backend.model.Person;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByName(String name);
    List<Person> findByNameAndAge(String name, Integer age);
    List<Person> findByNameOrAge(String name, Integer age);
    Person findByDogs_Id(Long id);

////    Long save(Person person);
//    Person read(Long id);
////    Long delete(Long id);
//    List<Long> saveAll(List<Person> persons);
//    List<Person> getAll();
}
