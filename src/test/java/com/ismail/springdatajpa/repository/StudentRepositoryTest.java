package com.ismail.springdatajpa.repository;

import com.ismail.springdatajpa.entity.Guardian;
import com.ismail.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest (this will allow testing of DB then deleting records)
class StudentRepositoryTest
{
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {
        Student student = Student.builder()
                .emailId("email@gmail.com")
                .firstName("Alex")
                .lastName("Rosa")
                //.guardianName("AlexFather")
                //.guardianEmail("guardian@gmail.com")
                //.guardianMobile("555555555")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian()
    {
        Guardian guardian = Guardian.builder()
                .name("GeorgeFather")
                .email("george.guardian@gmail.com")
                .mobile("555555555")
                .build();

        Student student = Student.builder()
                .emailId("goerge@gmail.com")
                .firstName("George")
                .lastName("Smith")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName()
    {
        List<Student> studentList = studentRepository.findByFirstName("Alex");

        System.out.println("Student: " + studentList);
    }

    @Test
    public void printStudentContainingFirstName()
    {
        List<Student> studentList = studentRepository.findByFirstNameContaining("ex");

        System.out.println("Student Containing: " + studentList);
    }

    @Test
    public void printAllStudents()
    {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Student list: " + studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName()
    {
        List<Student> studentList = studentRepository.findByGuardianName("AlexFather");

        System.out.println("Student list: " + studentList);
    }

    @Test
    public void printStudentByEmailAddress()
    {
        Student student = studentRepository.getStudentByEmailAddress("email@gmail.com");

        System.out.println("Student by email: " + student);
    }

    @Test
    public void printStudentByEmailAddressNative()
    {
        Student student = studentRepository.getStudentByEmailAddressNativeSQL("email@gmail.com");

        System.out.println("Student by email: " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam()
    {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParams("email@gmail.com");

        System.out.println("Student by email: " + student);
    }


    @Test
    public void printStudentFirstNameByEmailAddress()
    {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("email@gmail.com");

        System.out.println("Student FirstName by email: " + firstName);
    }

    @Test
    public void updateStudentNameByEmailId()
    {
        int update = studentRepository.updateStudentNameByEmailId("Alex Jones", "email@gmail.com");

    }


}