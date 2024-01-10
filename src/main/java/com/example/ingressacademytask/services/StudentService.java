package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Books;
import com.example.ingressacademytask.domains.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student userDto);

    Student findById(Long id);
    List<Student> findStudents(Long bookId);

    void deleteById(Long id);
    String addAuthorToSubc(Long studenId, Long authorId);

    String addBookToReadings(Long studentId, Long bookId);

    List<Books> getAllBooks(Long id);
}
