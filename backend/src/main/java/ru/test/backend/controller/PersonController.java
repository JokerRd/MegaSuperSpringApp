package ru.test.backend.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.test.backend.service.PersonService;
import ru.test.backend.dto.IdDto;
import ru.test.backend.dto.PersonDto;
import ru.test.backend.type.PersonInfo;
import ru.test.backend.type.ResultRegisterPerson;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public PersonDto getPerson(@Min(1) @RequestParam Long id) {
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
