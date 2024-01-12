package org.jpa.hibernate.repository;

import org.jpa.hibernate.entities.Course;
import org.jpa.hibernate.entities.Student;
import org.jpa.hibernate.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void printCourses() {
        List<Course> courses = repository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(Teacher.builder().firstName("T1").lastName("T1").build())
                .build();
        repository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
        List<Course> courses = repository.findAll(secondPageWithTwoRecords).getContent();
        Long totalElements = repository.findAll(secondPageWithTwoRecords).getTotalElements();
        long totalPages = repository.findAll(secondPageWithTwoRecords).getTotalPages();
        System.out.println(totalElements);
        System.out.println(totalPages);
        System.out.println(courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0, 2,
                        Sort.by("title").descending().and(Sort.by("credit")));
        List<Course> courses = repository.findAll(sortByTitle).getContent();
        System.out.println(courses);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courses = repository.findByTitleContaining("D", firstPageTenRecords).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Lizzy")
                .lastName("Morgan")
                .build();

        List<Student> students = List.of(Student.builder()
                .firstName("s1")
                .lastName("s1")
                .emailId("s1@gmail.com")
                .build()
        );

        Course course = Course.builder()
                .title("AI")
                .credit(6)
                .teacher(teacher)
                .students(students)
                .build();

        repository.save(course);
    }
}