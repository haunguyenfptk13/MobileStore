package com.hn.springbootmobilestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootApplication
public class SpringBootMobileStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMobileStoreApplication.class, args);
    }
}
