package com.upgrad.bookmyconsultation.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.upgrad.bookmyconsultation.enums.Speciality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "doctor")
public class Doctor {
	@Id
	@Column(name = "id", nullable = false)
	private String id = UUID.randomUUID().toString();

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Enumerated(EnumType.STRING)
	@Column(name = "speciality")
	private Speciality speciality;

	@Column(name = "dob")
	private String dob;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Address address;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "pan")
	private String pan;

	@Column(name = "highest_qualification")
	private String highestQualification;

	@Column(name = "college")
	private String college;

	@Column(name = "total_years_of_exp")
	private Integer totalYearsOfExp;

	@Column(name = "rating")
	private Double rating;

}
