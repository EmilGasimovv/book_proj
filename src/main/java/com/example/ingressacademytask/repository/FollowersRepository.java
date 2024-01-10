package com.example.ingressacademytask.repository;

import com.example.ingressacademytask.domains.Author;
import com.example.ingressacademytask.domains.Books;
import com.example.ingressacademytask.domains.Student;
import com.example.ingressacademytask.domains.predomains.Followers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FollowersRepository extends JpaRepository<Followers,Long> {
    @Query("SELECT r.author FROM Followers r WHERE r.student.id = :studentId")
    List<Author> findAuthorByStudentId(@Param("studentId") Long studentId);
    List<Followers> findFollowersByAuthor(Author author);
}
