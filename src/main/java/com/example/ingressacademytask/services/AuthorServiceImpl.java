package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Author;
import com.example.ingressacademytask.domains.Books;
import com.example.ingressacademytask.domains.predomains.Followers;
import com.example.ingressacademytask.dto.BookDto;
import com.example.ingressacademytask.email.EmalService;
import com.example.ingressacademytask.repository.AuthorRepository;
import com.example.ingressacademytask.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;
    private final BookService bookService;
    private final UserRepository userRepository;
    private final FollowersService followersService;

    @Override
    public String deleteBookById( Long bookId) {
        bookService.deleteBook(bookId);
        return "Book was deleted";
    }

    @Override
    public Books addBook(Long authorId, BookDto bookDto) {
        Author author = authorRepository.findById(authorId).orElseThrow(()-> new UsernameNotFoundException("Author not found"));
            Books books = Books.builder()
                    .name(bookDto.getName())
                    .author(author)
                    .build();
        bookService.createBook(books);
        List<Followers> studentList= followersService.findFollowersByAuthor(author);
        studentList.forEach(followers ->  EmalService.sendMail(author.getName() + " added new book", Collections.singletonList(followers.getStudent().getEmail())));
        return null;
    }

    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }

    @Override
    @Transactional
    public String deleteById(Long id) {
      Author author=  authorRepository.findById(id).orElseThrow();
        if(author!=null){
            authorRepository.deleteById(id);
            userRepository.deleteUserAuthEntitiesByEmail(author.getEmail());
            return "Deleted";
        }
        else{
            return "User Not found";
        }
    }
}
