package org.jpa.hibernate.service;

import org.jpa.hibernate.entities.Person;
import org.jpa.hibernate.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record PersonService(PersonRepository personRepository) {
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public Person getPersonById(Long id) {
        Optional<Person> p = personRepository.findById(id);
        return p.orElse(null);
    }
}