package com.h2h.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "departmentcode")
	private String departmentCode;
	
	@Column(name = "departmentname")
	private String departmentName;
	
	@Column(name = "departmentdesc")
	private String departmentDescription;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentCode=" + departmentCode + ", departmentName=" + departmentName
				+ ", departmentDescription=" + departmentDescription + "]";
	}
	
}
