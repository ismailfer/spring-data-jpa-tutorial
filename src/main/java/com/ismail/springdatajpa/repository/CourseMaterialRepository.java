package com.ismail.springdatajpa.repository;

import com.ismail.springdatajpa.entity.Course;
import com.ismail.springdatajpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long>
{
}
