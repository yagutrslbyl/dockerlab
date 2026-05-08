package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final PersonRepository repository;

    public HelloController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/hello")
    public String hello() {

        Person person = repository.findAll().stream()
                .findFirst()
                .orElse(null);

        if (person == null) {
            return "Hello, World!";
        }

        return "Hello, " + person.getName() + "!";
    }
}
