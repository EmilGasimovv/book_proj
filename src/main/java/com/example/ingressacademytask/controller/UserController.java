package com.example.ingressacademytask.controller;

import com.example.ingressacademytask.domains.Student;
import com.example.ingressacademytask.dto.UserDto;
import com.example.ingressacademytask.dto.UserRequest;
import com.example.ingressacademytask.dto.UserResponse;
import com.example.ingressacademytask.services.StudentService;
import com.example.ingressacademytask.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final StudentService studentService;

   @PostMapping("/signup")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        System.out.println("user dto");
        System.out.println(userDto);
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PostMapping("/signing")
    public ResponseEntity<UserResponse> signIn(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.loginUser(userRequest));
    }

    @GetMapping("/readers/{id}")
    public ResponseEntity<List<Student>> getUsers(@PathVariable Long id){
        return  ResponseEntity.ok(studentService.findStudents(id));
    }


}
