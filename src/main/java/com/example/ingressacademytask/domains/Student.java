package com.example.ingressacademytask.domains;

import com.example.ingressacademytask.domains.predomains.Followers;
import com.example.ingressacademytask.domains.predomains.Readings;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "ID")
    Long id;
    @Column(name = "STUDENT_NAME")
    String name;
    @Column(name = "STUDENT_EMAIL")
    String email;
    @Column(name = "STUDENT_AGE")
    int age;


//    @OneToMany(cascade = CascadeType.REMOVE , fetch = FetchType.LAZY, orphanRemoval = true)
//    private List<Readings> readings;

//    @OneToMany( cascade = CascadeType.REMOVE)
//    private List<Followers> follows;


}
