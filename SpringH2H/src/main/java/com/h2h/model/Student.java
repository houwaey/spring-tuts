package com.h2h.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/*@Entity
@Table(name = "student")*/
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "studentid", unique = true)
	private String studentId;
	
	@Embedded
	private PersonalInfo personalInfo;
	
	@Embedded
	private Address address;
	
	@Column(name = "yearlevel")
	private String yearLevel;
	
	@Column(name = "semester")
	private String semester;
	
	@Column(name = "schoolyear")
	private String schoolYear;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "createddate", updatable = false)
	private Date createdDate = new Date();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(String yearLevel) {
		this.yearLevel = yearLevel;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentId=" + studentId + ", personalInfo=" + personalInfo + ", address="
				+ address + ", yearLevel=" + yearLevel + ", semester=" + semester + ", schoolYear=" + schoolYear
				+ ", status=" + status + ", createdDate=" + createdDate + "]";
	}
	
}
