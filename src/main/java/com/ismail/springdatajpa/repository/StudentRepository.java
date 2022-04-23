package com.ismail.springdatajpa.repository;

import com.ismail.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
    // "ByFirstName" needs to exist; in order for this to work
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String name);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    // JPQL This query is on the class names; and not on the table names
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    // JPQL This query is on the class names; and not on the table names
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    // Native SQL
    @Query(
            value = "select s.* from tbl_student s where email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeSQL(String emailId);

    // Native SQL
    @Query(
            value = "select s.* from tbl_student s where email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParams(@Param("emailId") String emailId);

    @Query(
            value = "update tbl_student s set s.first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    @Modifying
    @Transactional
    int updateStudentNameByEmailId(String firstName, String emailId);

}
