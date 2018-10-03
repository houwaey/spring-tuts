package com.h2h.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

public class ResponseEntity<T> {

	private int code;
	private String message;
	private T data;
	private List<FieldErrorDto> fieldErrors;
	
	public ResponseEntity(HttpStatus httpStatus) {
		this.code = httpStatus.value();
		this.message = httpStatus.getReasonPhrase();
	}
	
	public ResponseEntity(HttpStatus httpStatus, List<FieldError> errors) {
		this.code = httpStatus.value();
		this.message = httpStatus.getReasonPhrase();
		
		List<FieldErrorDto> tempFieldErrors = new ArrayList<FieldErrorDto>();
		for (FieldError error : errors) {
			tempFieldErrors.add(new FieldErrorDto(error.getField(), error.getDefaultMessage()));
		}
		
		this.fieldErrors = tempFieldErrors;
	}
	
	public ResponseEntity(HttpStatus httpStatus, String customMessage) {
		this.code = httpStatus.value();
		this.message = customMessage;
	}
	
	public ResponseEntity(T data, HttpStatus httpStatus) {
		this.code = httpStatus.value();
		this.message = httpStatus.getReasonPhrase();
		this.data = data;
	}
	
	public ResponseEntity(T data, HttpStatus httpStatus, String customMessage) {
		this.code = httpStatus.value();
		this.message = customMessage;
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public T getData() {
		return data;
	}
	public List<FieldErrorDto> getFieldErrors() {
		return fieldErrors;
	}
}
