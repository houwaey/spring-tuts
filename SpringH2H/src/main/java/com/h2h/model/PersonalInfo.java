package com.h2h.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonalInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "middlename")
	private String middleName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "birthdate")
	private LocalDate birthDate;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("d/MM/yyyy"));
	}

	@Override
	public String toString() {
		return "PersonalInfo [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + "]";
	}
	
}