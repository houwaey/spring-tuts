package com.h2h.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2h.dto.ResponseEntity;
import com.h2h.exception.TeacherNotFoundException;
import com.h2h.model.Teacher;
import com.h2h.service.PersonService;

@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private PersonService<Teacher> teacherService;
	
	@PostMapping("/teacher")
	public ResponseEntity<Void> createTeacher(@RequestBody Teacher teacher) {
		boolean created = teacherService.create(teacher);
		if (!created) {
			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/teacher/all")
	public ResponseEntity<List<Teacher>> findAllTeachers() {
		List<Teacher> teachers = teacherService.findAll();
		if (teachers.size() <= 0) {
			return new ResponseEntity<List<Teacher>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Teacher>>(teachers, HttpStatus.OK);
	}
	
	@GetMapping("/teacher/id/{id}")
	public ResponseEntity<Teacher> findTeacherById(@PathVariable("id") long id) {
		Teacher teacher = teacherService.findOneById(id);
		if (teacher == null) {
			throw new TeacherNotFoundException();
		}
		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
	}
	 
}