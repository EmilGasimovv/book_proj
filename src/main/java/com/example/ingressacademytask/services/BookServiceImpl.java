package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Books;
import com.example.ingressacademytask.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    @Override
    public Books findBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(()-> new UsernameNotFoundException(" Book Not Found"));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Books createBook(Books books) {
        return bookRepository.save(books);
    }
}
