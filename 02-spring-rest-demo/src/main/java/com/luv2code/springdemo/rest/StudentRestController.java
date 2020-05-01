package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	// define @PostConstructor to load the student data ... only once.
	@PostConstruct
	public void loadData() {

		students = new ArrayList<Student>();

		students.add(new Student("Siddarth", "Mishra"));
		students.add(new Student("Nikhita", "Sharma"));
		students.add(new Student("Mario", "Rossi"));

	}

	// define end point for "/students" to return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {

		return students;
	}

	// define end point for "/student/{stuentId}" to return particular student by
	// index of list
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable("studentId") int index) {

		// check the id against list size
		if (students.size() <= index || index < 0) {
			throw new StudentNotFoundException("Student id not found - " + index);
		}

		return students.get(index);
	}
}
