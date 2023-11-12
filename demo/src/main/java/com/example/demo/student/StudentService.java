package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

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

	public void deleteStudent(Long studentId) {

		boolean exist = studentRepository.existsById(studentId); //This will check if the student exists

		if(!exist) { //If the student does not exist
			throw new IllegalStateException("student with id " + studentId + " does not exist"); //Throw an exception
		}

		studentRepository.deleteById(studentId); //This will delete the student with the given id
	}

	@Transactional // Transactional annotation will allow us to update the student object without using a query
	public void updateStudent(Long studentId, String name, String email) {

		Student student = studentRepository.findById(studentId)
			.orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist")); //This will check if the student exists

		if(name != null && name.length() > 0 && !student.getName().equals(name)) { //If the name is not null or empty and if the name is different than the current name
			student.setName(name); //Set the new name
		}

		if(email != null && email.length() > 0 && !student.getEmail().equals(email)) { //If the email is not null or empty and if the email is different than the current email
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email); //This will check if the email is already taken

			if(studentOptional.isPresent()) { //If the email is already taken
				throw new IllegalStateException("email taken"); //Throw an exception
			}

			student.setEmail(email); //Set the new email
		}
	}
}