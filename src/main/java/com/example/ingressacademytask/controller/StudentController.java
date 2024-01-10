package com.example.ingressacademytask.controller;

import com.example.ingressacademytask.domains.Books;
import com.example.ingressacademytask.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


//    Add Book to your redinglist
    @PostMapping("{studentId}/add-book/{bookId}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<String> addBook(@PathVariable Long studentId, @PathVariable Long bookId){
        return ResponseEntity.ok(studentService.addBookToReadings(studentId,bookId)) ;
    }


//    Subscribe to author
    @PostMapping("/{studentId}/add-author/{authorId}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<String> addAuthorToSub(@PathVariable Long studentId, @PathVariable Long authorId){
        return ResponseEntity.ok(studentService.addAuthorToSubc(studentId,authorId));
    }

//    Get currently read books
    @GetMapping("/books/{id}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<List<Books>> getAllReadingBooks(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getAllBooks(id));
    }


}
