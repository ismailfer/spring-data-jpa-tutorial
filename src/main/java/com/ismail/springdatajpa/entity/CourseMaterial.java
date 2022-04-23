package com.ismail.springdatajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "course")
@Builder
public class CourseMaterial
{
    @Id
    @SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
    private Long courseMaterialId;

    private String url;


    @OneToOne(
            cascade = CascadeType.ALL,   // Cascading means; add course data in table before adding course material
            fetch = FetchType.LAZY,      // Eager: fetch course data when we fetch courseMaterial data; Lazy: don't
            optional = false             // Indicate this one-to-one relationship is mandatory; and not optional
    )
    @JoinColumn(
            name = "course_id",   // this field will be created on course_material table; referencing foreign key courseId
            referencedColumnName = "courseId"
    )
    private Course course;
}
