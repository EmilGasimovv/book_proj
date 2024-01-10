package com.example.ingressacademytask.repository;

import com.example.ingressacademytask.domains.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}
