package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/persons")
    public List<Person> getAll() {
        return repository.findAll();
    }


    @GetMapping("/hello")
    public String hello() {
        return repository.findAll()
                .stream()
                .findFirst()
                .map(p -> "Hello, " + p.getName() + "!")
                .orElse("Hello, World!");
    }
}