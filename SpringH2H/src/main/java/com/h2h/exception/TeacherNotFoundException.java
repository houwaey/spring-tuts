package com.h2h.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TeacherNotFoundException extends NotFoundException {

	private static final long serialVersionUID = 1L;

	public TeacherNotFoundException() {
		super("Teacher not found");
	}
	
	public TeacherNotFoundException(String exception) {
		super(exception);
	}
	
}
