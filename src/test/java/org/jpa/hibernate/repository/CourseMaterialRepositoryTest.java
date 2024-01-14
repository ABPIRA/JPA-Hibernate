package org.jpa.hibernate.repository;

import org.jpa.hibernate.entities.Course;
import org.jpa.hibernate.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial() {
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.dailyCodeBuffer.com")
                .course(Course.builder().title(".net").credit(6).build())
                .build();
        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterialList = repository.findAll();
        System.out.println(courseMaterialList);
    }
}