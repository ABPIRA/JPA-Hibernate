package org.jpa.hibernate.repository;

import org.jpa.hibernate.entities.Guardian;
import org.jpa.hibernate.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentWithGuardian() {
        Student student = Student.builder()
                .firstName("Reza")
                .lastName("Bostanpira")
                .emailId("reza@gmail.com")
                .guardian(Guardian.builder().name("zbpira").email("zbpira@gmail.com").mobile("999").build())
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("Ali");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("R");
        System.out.println(studentList);
    }

    @Test
    public void printStudentWithLastNameNotNull() {
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println(studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("abpira");
        System.out.println(studentList);
    }

    @Test
    public void printStudentWithFirstAndLastName() {
        Student student = studentRepository.findByFirstNameAndLastName("Ali", "Bostanpira");
        System.out.println(student);
    }

    @Test
    public void printStudentWithEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("radin@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentWithEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("radin@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentWithEmailAddressNativeWithParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParameter("radin@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameWithEmailAddress() {
        studentRepository.updateStudentNameByEmailId("Ali", "abpira@gmail.com");
    }
}