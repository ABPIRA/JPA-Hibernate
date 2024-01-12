package org.jpa.hibernate.repository;

import org.jpa.hibernate.entities.Course;
import org.jpa.hibernate.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("T1")
                .lastName("T1")
                //.courses(List.of(
                  //      Course.builder().title("DBA").credit(5).build(),
                    //    Course.builder().title("Java").credit(6).build()))
                .build();
        repository.save(teacher);
    }
}