package ru.test.controller;

import org.springframework.web.bind.annotation.*;
import ru.test.PersonInfo;

@RestController
public class TestController {

    private String name = "Федор";

    @GetMapping("/person/{id}/name")
    public String test(@PathVariable Integer id) {
        System.out.println(id);
        return name;
    }

    @PostMapping("/person/test")
    public void testPost(@RequestBody PersonInfo personInfo) {
        name = personInfo.getName();
    }

}
