package org.jpa.hibernate.repository;

import org.jpa.hibernate.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String name);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT s FROM Student s WHERE s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query(value = "SELECT * FROM student s WHERE s.email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    @Query(value = "SELECT * FROM student s WHERE s.email_address = :email", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParameter(@Param("email") String emailId);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.firstName = ?1 WHERE s.emailId = ?2")
    void updateStudentNameByEmailId(String name, String emailId);
}