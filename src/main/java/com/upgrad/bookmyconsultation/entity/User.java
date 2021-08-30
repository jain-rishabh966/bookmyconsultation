package com.upgrad.bookmyconsultation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "user")
public class User {

	@Id
	@Column(name = "email_id", nullable = false)
	private String emailId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "dob")
	private String dob;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "password")
	private String password;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "salt")
	private String salt;

}
