package com.example.ingressacademytask.repository;

import com.example.ingressacademytask.domains.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Books,Long> {
}
