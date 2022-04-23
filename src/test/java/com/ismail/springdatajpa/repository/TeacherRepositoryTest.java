package com.ismail.springdatajpa.repository;

import com.ismail.springdatajpa.entity.Course;
import com.ismail.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest
{
    @Autowired
    public TeacherRepository teacherRepository;

    @Test
    public void saveTeacher()
    {
        Course course1 = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course course2 = Course.builder()
                .title("Java")
                .credit(8)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Qutub")
                .lastName("Khan")
                //.courses(List.of(course1, course2))
                .build();

        teacherRepository.save(teacher);
    }
}