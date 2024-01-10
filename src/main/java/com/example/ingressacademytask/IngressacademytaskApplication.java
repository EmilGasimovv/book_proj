package com.example.ingressacademytask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//        exclude = { SecurityAutoConfiguration.class })
public class IngressacademytaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(IngressacademytaskApplication.class, args);
    }

}
