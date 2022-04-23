package com.ismail.springdatajpa.repository;

import com.ismail.springdatajpa.entity.Course;
import com.ismail.springdatajpa.entity.Student;
import com.ismail.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest
{
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourseWithTeacher()
    {
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher()
    {

        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Singh")
                .emailId("abhishek@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudent(student);

        courseRepository.save(course);
    }

    @Test
    public void printAllCourses()
    {
        List<Course> courses = courseRepository.findAll();

        System.out.println("Courses: " + courses);
    }

    @Test
    public void findAllPagination()
    {
        Pageable firstPathWith3Records = PageRequest.of(0, 3);

        Pageable secondPathWith2Records = PageRequest.of(1, 2);

        Page<Course> coursesPage = courseRepository.findAll(secondPathWith2Records);


        Long totalElements = coursesPage.getTotalElements();

        System.out.println("Total pages: " + coursesPage.getTotalPages());

        System.out.println("Total elements: " + coursesPage.getTotalElements());

        System.out.println("Courses: " + coursesPage.getContent());


    }

    @Test
    public void findAllSorting()
    {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title").ascending());

        Pageable sortByCredit = PageRequest.of(0, 2, Sort.by("credit").ascending());

        Pageable sortByTitleAndCredit = PageRequest.of(0, 2, Sort.by("title").ascending().and(Sort.by("credit").ascending()));

        Page<Course> coursesPage = courseRepository.findAll(sortByTitle);

        System.out.println("Courses: " + coursesPage.getContent());


    }


    @Test
    public void printFindByTitleContaining()
    {
        Pageable firstPage10Records = PageRequest.of(0, 10);

        Page<Course> coursesPage = courseRepository.findByTitleContaining("D", firstPage10Records);

        System.out.println("Courses: " + coursesPage.getContent());


    }



}