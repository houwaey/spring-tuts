package com.h2h.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "subjectcode")
	private String subjectCode;
	
	@Column(name = "subjectname")
	private String subjectName;
	
	@Column(name = "subjectdesc")
	private String subjectDescription;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectDescription() {
		return subjectDescription;
	}

	public void setSubjectDescription(String subjectDescription) {
		this.subjectDescription = subjectDescription;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName
				+ ", subjectDescription=" + subjectDescription + "]";
	}

}
