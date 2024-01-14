package org.jpa.hibernate.repository;

import org.jpa.hibernate.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
