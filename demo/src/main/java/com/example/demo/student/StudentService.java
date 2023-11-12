package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

	@Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

	public void addNewStudent(Student student) {
		
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail()); //This will check if the email is already taken

		if(studentOptional.isPresent()) { //If the email is already taken
			throw new IllegalStateException("email taken"); //Throw an exception
		}
		studentRepository.save(student); //This will save the student object to the database
		System.out.println(student); //This will print the student object


	}
}