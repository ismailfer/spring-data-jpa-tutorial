package com.ismail.springdatajpa.repository;

import com.ismail.springdatajpa.entity.Course;
import com.ismail.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest
{
    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial()
    {
        Course course = Course.builder()
                .title(".Net")
                .credit(8)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.dailycodebuffer.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials()
    {
        List<CourseMaterial> courseMaterialList = repository.findAll();

        System.out.println("Course Materials: " + courseMaterialList);
    }
}