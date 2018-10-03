package com.h2h.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.h2h.annotations.Age;
import com.h2h.util.Constant;
import com.h2h.util.RegexPattern;

@Entity
@Table(name = "user")
public class WebUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@NotNull(message = "{username.notnull}")
	@Column(name = "username", updatable = false, unique = true)
	private String username;
	
	@NotNull(message = "{username.notnull}")
	@Size(min = 5, max = 20, message = "{password.size}")
	@Column(name = "password")
	private String password;
	
	@NotNull(message = "{email.notempty}")
	@Pattern(regexp = RegexPattern.EMAIL_PATTERN, message = "{email.pattern}")
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "{birthdate.notnull}")
	@Age(value = 18, message = "{birthdate.age}")
	@Column(name = "birthdate")
	private LocalDate birthDate;
	
	@NotNull(message = "{status.notnull}")
	@Column(name = "status")
	private String status = Constant.INACTIVE;
	
	public WebUser() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("d/MM/yyyy"));
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "WebUser [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", birthDate=" + birthDate + ", status=" + status + "]";
	}
	
}
