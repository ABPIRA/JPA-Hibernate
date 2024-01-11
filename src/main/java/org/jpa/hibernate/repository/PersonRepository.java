package org.jpa.hibernate.repository;

import org.jpa.hibernate.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}