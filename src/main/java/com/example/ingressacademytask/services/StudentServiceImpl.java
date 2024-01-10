package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Author;
import com.example.ingressacademytask.domains.Books;
import com.example.ingressacademytask.domains.Student;
import com.example.ingressacademytask.repository.AuthorRepository;
import com.example.ingressacademytask.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final AuthorRepository authorRepository;
    private final BookService bookService;
    private final ReadingsService readingsService;
    private final FollowersService followersService;

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public String addBookToReadings(Long studentId, Long bookId) {
        return readingsService.addBook(studentId,bookId);
    }

    @Override
    public List<Student> findStudents(Long bookId) {
        Books books = bookService.findBookById(bookId);
        return readingsService.findStudentsByBooks(bookId);
    }

    @Override
    public List<Books> getAllBooks(Long id) {
        return readingsService.getBookByStudentId(id);
    }

    @Override
    public String addAuthorToSubc(Long studenId, Long authorId) {
        Student student = studentRepository.findById(studenId).orElseThrow();
        Author author = authorRepository.findById(authorId).orElseThrow();

       return followersService.addFollower(student,author);

    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("Student not found"));
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }
}
