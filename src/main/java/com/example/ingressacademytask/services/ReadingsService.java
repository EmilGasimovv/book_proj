package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Books;
import com.example.ingressacademytask.domains.Student;
import com.example.ingressacademytask.domains.predomains.Readings;
import com.example.ingressacademytask.repository.BookRepository;
import com.example.ingressacademytask.repository.ReadingsRepository;
import com.example.ingressacademytask.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadingsService {
    private final ReadingsRepository readingsRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;

    public String addBook(Long studentId, Long book_id) {
        Books books = bookRepository.findById(book_id).orElseThrow();
        if (!getBookByStudentId(studentId).contains(books)) {
            Student student = studentRepository.findById(studentId).orElseThrow();
            Readings readings = Readings.builder()
                    .student(student)
                    .books(books)
                    .build();
            readingsRepository.save(readings);
            return books.getName() + " was added";
        } else {
            return "This book already exist at your readlist";
        }
    }

    public List<Books> getBookByStudentId(Long studentId) {
        List<Readings> readingsList = readingsRepository.findReadingsByStudentId(studentId);
        List<Books> booksList = new ArrayList<>();
        readingsList.stream().forEach(readings -> booksList.add(new Books(readings.getBooks().getId(), readings.getBooks().getName(), readings.getBooks().getAuthor())));
        return booksList;
    }

    public List<Student> findStudentsByBooks(Long bookId) {
        return readingsRepository.findReadingsByBooks_Id(bookId);
    }
}
