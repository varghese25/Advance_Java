package com.varghese.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.varghese.restapi.entity.Student;
import com.varghese.restapi.repository.StudentRespository;

@RestController
public class StudentController {

	@Autowired
	StudentRespository repo; // Autowired studenRepo which is connected inbuilt springBoot JPA and CRUD 

	// get all the students
	// localhost:8080/students

	@GetMapping("/students")

	public List<Student> getAllStudents() {

		List<Student> students = repo.findAll();

		return students;
	}

	// Get: localhost:8080/students/1 .its used pull specific record from postman

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {

		Student student = repo.findById(id).get();

		return student;

	}

	// adding student using Post: localhost:8080/student/add post method dont
	// include id auto increment
	@PostMapping("/student/add")
	@ResponseStatus(code = HttpStatus.CREATED) // response show 201 status when we add student
	public void CreateStudent(@RequestBody Student student) {

		repo.save(student);
	}

	@PutMapping("/student/update/{id}")
	public Student UpdateStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		student.setName("Varghese Baby");
		student.setPercentage(99);
		repo.save(student);
		return student;

	}

	@DeleteMapping("/student/delete/{id}")
	public void DeleteStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		repo.delete(student);
	}

}
