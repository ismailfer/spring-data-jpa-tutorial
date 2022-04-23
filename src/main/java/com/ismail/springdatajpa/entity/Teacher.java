package com.ismail.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher
{
    @Id
    @SequenceGenerator(
            name="teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private long teacherId;

    private String firstName;

    private String lastName;

    /* OneToMany
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="teacher_id",                  // this will automatically add a foreign key field in courses table
            referencedColumnName = "teacherId"
    )
    private List<Course> courses;
     */
}
