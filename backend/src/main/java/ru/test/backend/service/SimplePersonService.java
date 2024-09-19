package ru.test.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.backend.dto.PersonDto;
import ru.test.backend.integration.PersonExternalSource;
import ru.test.backend.model.Person;
import ru.test.backend.repository.PersonRepository;
import ru.test.backend.type.PersonInfo;
import ru.test.backend.type.ResultRegisterPerson;
import ru.test.backend.util.IdService;

import static ru.test.backend.type.ResultRegisterPerson.success;

@Service
@RequiredArgsConstructor
public class SimplePersonService implements PersonService {

    private final PersonExternalSource personExternalSource;
    private final PersonRepository personRepository;
    private final IdService idService;

    @Override
    @Transactional
    public ResultRegisterPerson registerPerson(PersonInfo personInfo) {
//        if (!isValid(personInfo)) {
//            return error("Указаны неверные данные");
//        }
//        if (!personExternalSource.isTrustedPerson(personInfo.getName(), personInfo.getAge())) {
//            return error("Переданные данные не являются подтвержденными");
//        }
        var person = new Person(null, personInfo.getName(), personInfo.getAge(), null, null);
        person = personRepository.save(person);
        doIt();
        return success(person.getId());
    }

    private void doIt() {
        throw new RuntimeException();
    }

    @Override
    public PersonDto get(long id) {
        return personRepository
                .findById(id)
                .map(person -> new PersonDto(person.getId(), person.getName(), person.getAge()))
                .orElse(null);
    }

    @Override
    public Long updatePerson(PersonDto personInfo) {
        var person = new Person(personInfo.getId(), personInfo.getName(), personInfo.getAge(), null, null);
        return personRepository.save(person).getId();
    }

    @Override
    public void deletePerson(long id) {
        personRepository.deleteById(id);
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
