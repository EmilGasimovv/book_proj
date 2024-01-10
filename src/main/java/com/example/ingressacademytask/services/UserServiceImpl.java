package com.example.ingressacademytask.services;

import com.example.ingressacademytask.config.JwtService;
import com.example.ingressacademytask.domains.Author;
import com.example.ingressacademytask.domains.Student;
import com.example.ingressacademytask.domains.UserAuthEntity;
import com.example.ingressacademytask.dto.UserDto;
import com.example.ingressacademytask.dto.UserRequest;
import com.example.ingressacademytask.dto.UserResponse;
import com.example.ingressacademytask.enums.UserType;
import com.example.ingressacademytask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final StudentService studentService;
    private final AuthorService authorService;

    @Override
    public UserDto createUser(UserDto userDto) {
        String hashedPass = passwordEncoder.encode(userDto.getPassword());
        UserAuthEntity user = UserAuthEntity.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .age(userDto.getAge())
                .userType(userDto.getUserType())
                .password(hashedPass)
                .build();
        userRepository.save(user);
        if (userDto.getUserType().equals(UserType.STUDENT)) {
            UserAuthEntity userAuth = userRepository.findUserByEmail(userDto.getEmail()).orElseThrow();
            Student student = Student.builder()
                    .id(userAuth.getId())
                    .name(userDto.getName())
                    .age(userDto.getAge())
                    .email(userDto.getEmail())
                    .build();
            studentService.addStudent(student);
        } else if (userDto.getUserType().equals(UserType.AUTHOR)) {
            UserAuthEntity userAuth = userRepository.findUserByEmail(userDto.getEmail()).orElseThrow();
            Author author = Author.builder()
                    .id(userAuth.getId())
                    .name(userDto.getName())
                    .age(userDto.getAge())
                    .email(userAuth.getEmail())
                    .build();
            authorService.addAuthor(author);
        }
        return userDto;
    }

    @Override
    public UserResponse loginUser(UserRequest userRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getEmail(), userRequest.getPassword()));
        UserAuthEntity user = userRepository.findUserByEmail(userRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        String token = jwtService.generateToken(user);
        return UserResponse.builder().userToken(token).build();
    }

}
