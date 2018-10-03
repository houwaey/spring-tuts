package com.h2h.dto;

public class FieldErrorDto {

	private String field;
	private String message;
	
	/**
	 * @param field
	 * @param message
	 */
	public FieldErrorDto(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}

}