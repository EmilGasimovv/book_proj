package com.example.ingressacademytask.repository;

import com.example.ingressacademytask.domains.Author;
import com.example.ingressacademytask.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
