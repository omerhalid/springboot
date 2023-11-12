package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student omer = new Student(
                "Omer",
                LocalDate.of(1997, Month.JULY, 9),
                "omerhalidcinar@gmail.com");

            Student bilal = new Student(
                "Bilal",
                LocalDate.of(1997, Month.SEPTEMBER, 23),
                "bllakcn35@gmail.com");

            repository.saveAll(
                List.of(omer, bilal)
            );
        };
    }
}
