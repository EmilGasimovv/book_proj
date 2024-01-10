package com.example.ingressacademytask.domains;

import com.example.ingressacademytask.domains.predomains.Followers;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "authors")
public class Author{
    @Id
    Long id;
    @Column(name = "AUTHOR_NAME")
    String name;
    @Column(name = "AUTHOR_AGE")
    int age;
    @Column(name = "AUTHOR_EMAIL")
    String email;
//
//    @OneToMany( cascade = CascadeType.REMOVE, orphanRemoval = true)
//    @JsonManagedReference
//    private List<Books> books;

//    @OneToMany( cascade = CascadeType.REMOVE, orphanRemoval = true)
//    @JsonManagedReference
//    private List<Followers> followers;


}
