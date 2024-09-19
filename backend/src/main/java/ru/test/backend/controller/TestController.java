package ru.test.backend.controller;

import org.springframework.web.bind.annotation.*;
import ru.test.backend.PersonInfo;
import ru.test.backend.aop.LogRequest;

@RestController
public class TestController {

    private String name = "Федор";

    @GetMapping("/person/{id}/name")
    @LogRequest
    public String test(@PathVariable Integer id) {
        System.out.println(id);
        return name;
    }

    @GetMapping("/person/teststsetst")
    public void test2() {
        test(1);
    }

    @PostMapping("/person/test")
    public void testPost(@RequestBody PersonInfo personInfo) {
        name = personInfo.getName();
    }

}
