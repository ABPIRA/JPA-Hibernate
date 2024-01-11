package org.jpa.hibernate.controller;

import org.jpa.hibernate.entities.Person;
import org.jpa.hibernate.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public record PersonController(PersonService personService) {
    @PostMapping("/person")
    public void savePerson(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @GetMapping("/person")
    public Person getPerson(@RequestParam Long id) {
        return personService.getPersonById(id);
    }
}