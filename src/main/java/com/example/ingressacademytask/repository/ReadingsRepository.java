package com.example.ingressacademytask.repository;

import com.example.ingressacademytask.domains.Books;
import com.example.ingressacademytask.domains.Student;
import com.example.ingressacademytask.domains.predomains.Readings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ReadingsRepository extends JpaRepository<Readings,Long> {

    List<Readings> findReadingsByStudentId( Long student);
    List<Student> findReadingsByBooks_Id(Long book);




}
