package com.ismail.springdatajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder  // produces complex builder api for this class
@Table(name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email_address")
)
public class Student
{
    // Student Entity

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long studentId;

    private String firstName;

    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailId;


    @Embedded
    private Guardian guardian;

}
