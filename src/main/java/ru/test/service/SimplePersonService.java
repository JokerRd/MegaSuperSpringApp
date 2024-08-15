package ru.test.service;

import org.springframework.stereotype.Service;
import ru.test.dto.PersonDto;
import ru.test.integration.PersonExternalSource;
import ru.test.model.Person;
import ru.test.repository.PersonRepository;
import ru.test.type.PersonInfo;
import ru.test.type.ResultRegisterPerson;
import ru.test.util.IdService;

import static ru.test.type.ResultRegisterPerson.error;
import static ru.test.type.ResultRegisterPerson.success;

@Service
public class SimplePersonService implements PersonService {

    private final PersonExternalSource personExternalSource;
    private final PersonRepository personRepository;
    private final IdService idService;

    public SimplePersonService(PersonExternalSource personExternalSource,
                               PersonRepository personRepository,
                               IdService idService) {
        this.personExternalSource = personExternalSource;
        this.personRepository = personRepository;
        this.idService = idService;
    }

    @Override
    public ResultRegisterPerson registerPerson(PersonInfo personInfo) {
        if (!isValid(personInfo)) {
            return error("Указаны неверные данные");
        }
        if (!personExternalSource.isTrustedPerson(personInfo.getName(), personInfo.getAge())) {
            return error("Переданные данные не являются подтвержденными");
        }

        var id = idService.getNextId();
        var person = new Person(id, personInfo.getName(), personInfo.getAge());
        personRepository.save(person);

        return success(id);
    }

    @Override
    public PersonDto get(long id) {
        var person = personRepository.read(id);
        if (person == null) {
            return null;
        }
        return new PersonDto(person.getId(), person.getName(), person.getAge());
    }

    @Override
    public Long updatePerson(PersonDto personInfo) {
        var person = new Person(personInfo.getId(), personInfo.getName(), personInfo.getAge());
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(long id) {
        personRepository.delete(id);
    }

    private boolean isValid(PersonInfo personInfo) {
        if (personInfo == null) {
            return false;
        }
        if (personInfo.getName() == null || personInfo.getName().isEmpty()) {
            return false;
        }
        if (personInfo.getAge() < 0 || personInfo.getAge() > 150) {
            return false;
        }
        return true;
    }


}
