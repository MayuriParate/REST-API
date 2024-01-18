package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	StudentRepository studentRepository; 
	
	@PostMapping("/student")
	public String createNewStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return "Student Created in database";
		}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> stdList = new ArrayList<>(); 
		 studentRepository.findAll().forEach(stdList::add);
		 return new ResponseEntity<List<Student>>(stdList,HttpStatus.OK);
	}
	
	@GetMapping("/student/{std_id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long std_id){
		Optional<Student> std = studentRepository.findById(std_id);
		if(std.isPresent()) {
			return new ResponseEntity<Student>(std.get(),HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/student/{std_id}")
	public String updateStudentById(@PathVariable long std_id,@RequestBody Student student){
		Optional<Student> std = studentRepository.findById(std_id);
		if(std.isPresent()) {
			Student exitStd = std.get();
			exitStd.setStd_name(student.getStd_name());
			exitStd.setStd_email(student.getStd_email());
			exitStd.setStd_age(student.getStd_age());
			studentRepository.save(exitStd);
			return "Student Details against Id " +std_id+" updated";

		}
		else {
			return "Student Details does not exist for stdid "+std_id;
		}
	}
	
	@DeleteMapping("/student/{std_id}")
	public String deleteStudentByStdId(@PathVariable Long std_id) {
		studentRepository.deleteById(std_id);
		return "Student Deleted Successfully";
	}
	
	@DeleteMapping("/student")
	public String deleteAllStudents() {
		studentRepository.deleteAll();
		return "Student deleted successfully...";
	}
 
}
