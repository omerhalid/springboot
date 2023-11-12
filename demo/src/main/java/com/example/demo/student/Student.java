// This is a student class in the student package

// Path: demo/src/main/java/com/example/demo/student/Student.java

package com.example.demo.student;

import java.time.LocalDate;

public class Student{
 
    private Long id;
    private String name;
    private Integer age;
    private LocalDate dob;
    private String email;

    //Constructor without fields
    public Student() {
    }

    //Constructor with all fields
    public Student(Long id, String name, Integer age, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }

    //Constructor without id because database will generate it
    public Student(String name, Integer age, LocalDate dob, String email) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }

    // Getters and Setters for all fields

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public Integer getAge() {
        return age;
    }

    // Setter for age
    public void setAge(Integer age) {
        this.age = age;
    }

    // Getter for dob
    public LocalDate getDob() {
        return dob;
    }

    // Setter for dob
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // toString method
    @Override  
    public String toString() {
        return "Student [age=" + age + ", dob=" + dob + ", email=" + email + ", id=" + id + ", name=" + name + "]";
    }

}