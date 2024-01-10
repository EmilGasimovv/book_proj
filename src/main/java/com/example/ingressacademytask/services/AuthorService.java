package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Author;
import com.example.ingressacademytask.domains.Books;
import com.example.ingressacademytask.dto.BookDto;

public interface AuthorService {

    void addAuthor(Author userDto);

    Author findById(Long id);


    String deleteById(Long id);
    Books addBook(Long authorId, BookDto bookDto);

    String  deleteBookById( Long bookId);
}
