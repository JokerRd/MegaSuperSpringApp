package ru.test.service;

import ru.test.dto.PersonDto;
import ru.test.type.PersonInfo;
import ru.test.type.ResultRegisterPerson;

public interface PersonService {

    /**
     * На вход получает какие то данные откуда то, проверяет существует ли такой человек, если да, то заводит в систему
     */
    ResultRegisterPerson registerPerson(PersonInfo personInfo);

    PersonDto get(long id);

    Long updatePerson(PersonDto personInfo);

    void deletePerson(long id);
}
