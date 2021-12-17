package com.example.enoca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing //created date calışması için
@EnableJpaRepositories
public class EnocaApplication {

    public static void main(String[] args) {

        SpringApplication.run(EnocaApplication.class, args);
    }

}
