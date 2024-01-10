package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Books;

public interface BookService {
    Books createBook(Books books);
    void deleteBook(Long id);
    Books findBookById(Long bookId);

}
