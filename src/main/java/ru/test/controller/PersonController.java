package ru.test.controller;

import org.springframework.web.bind.annotation.*;
import ru.test.dto.IdDto;
import ru.test.dto.PersonDto;
import ru.test.service.PersonService;
import ru.test.type.PersonInfo;
import ru.test.type.ResultRegisterPerson;

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
    public PersonDto getPerson(@Valid @Min(1) @RequestParam Long id) {
        return personService.get(id);
    }

    @PostMapping("/")
    public ResultRegisterPerson createPerson(@Valid @RequestBody PersonInfo personInfo) {
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
