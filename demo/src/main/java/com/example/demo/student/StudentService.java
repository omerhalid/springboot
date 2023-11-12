package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//solve the bean error
@Service
public class StudentService {
	public List<Student> getStudents() {
		return List.of(
				new Student(
						1L,
						"Ömer",
						25,
						LocalDate.of(1997, Month.JULY, 9),
						"omerhalidcinar@gmail.com"
			)
		);
	}
    
}
