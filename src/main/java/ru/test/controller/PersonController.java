package ru.test.controller;

import org.springframework.web.bind.annotation.*;
import ru.test.dto.IdDto;
import ru.test.dto.PersonDto;
import ru.test.service.PersonService;
import ru.test.type.PersonInfo;
import ru.test.type.ResultRegisterPerson;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable long id) {
        if (id < 0) {
            throw new IllegalArgumentException("id must be a positive integer");
        }

        return personService.get(id);
    }

    @PostMapping("/")
    public ResultRegisterPerson createPerson(@RequestBody PersonInfo personInfo) {
        return personService.registerPerson(personInfo);
    }

    @PutMapping("/")
    public IdDto updatePerson(@RequestBody PersonDto personDto) {
        var id = personService.updatePerson(personDto);
        return new IdDto(id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable long id) {
        personService.deletePerson(id);
    }


}
