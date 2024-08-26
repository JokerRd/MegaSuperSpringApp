package ru.test.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoRestConrotller {

    @GetMapping("/test2")
    public String test() {
        return "test.html";
    }

}
