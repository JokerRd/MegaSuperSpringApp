package ru.test.backend.service;

import ru.test.backend.dto.PersonDto;
import ru.test.backend.type.PersonInfo;
import ru.test.backend.type.ResultRegisterPerson;

public interface PersonService {

    /**
     * На вход получает какие то данные откуда то, проверяет существует ли такой человек, если да, то заводит в систему
     */
    ResultRegisterPerson registerPerson(PersonInfo personInfo);

    PersonDto get(long id);

    Long updatePerson(PersonDto personInfo);

    void deletePerson(long id);
}
