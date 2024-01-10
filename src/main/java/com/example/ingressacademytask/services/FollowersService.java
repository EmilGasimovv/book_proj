package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Author;
import com.example.ingressacademytask.domains.Student;
import com.example.ingressacademytask.domains.predomains.Followers;
import com.example.ingressacademytask.repository.FollowersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowersService {
    private final FollowersRepository followersRepository;
    public String addFollower(Student student, Author author){
        List<Author> authors = followersRepository.findAuthorByStudentId(student.getId());
        if(!authors.contains(author)){
            Followers followers = Followers.builder()
                    .student(student)
                    .author(author)
                    .build();
            followersRepository.save(followers);
            return author.getName() + " was followed";
        }
        else {
            return " You are already following this author";
        }
    }

    public List<Followers> findFollowersByAuthor(Author author) {
        return followersRepository.findFollowersByAuthor(author);
    }
}
