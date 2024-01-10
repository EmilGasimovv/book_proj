package com.example.ingressacademytask.controller;

import com.example.ingressacademytask.domains.Books;
import com.example.ingressacademytask.dto.BookDto;
import com.example.ingressacademytask.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

//    Delete Own Account
    @DeleteMapping("/delete-account/{id}")
    @PreAuthorize("hasRole('AUTHOR')")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        return ResponseEntity.ok(authorService.deleteById(id)) ;
    }
//Add Book
    @PostMapping("/post-book/{id}")
    @PreAuthorize("hasRole('AUTHOR')")
    public ResponseEntity<Books>  addBook(@PathVariable Long id, @RequestBody BookDto bookDto){
       return ResponseEntity.ok(authorService.addBook(id,bookDto)) ;
    }
//    Delete Own Book
    @DeleteMapping("/delete-book/{bookId}")
    @PreAuthorize("hasRole('AUTHOR')")
    public ResponseEntity<String> deleteBook( @PathVariable Long bookId){
        return ResponseEntity.ok(authorService.deleteBookById(bookId)) ;
    }
}
