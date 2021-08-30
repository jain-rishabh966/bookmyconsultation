package com.upgrad.bookmyconsultation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
public class Appointment {
	@Id
	@Column(name = "appointment_id", nullable = false)
	private String appointmentId = UUID.randomUUID().toString();

	@Column(name = "doctor_id")
	private String doctorId;

	@Column(name = "doctor_name")
	private String doctorName;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_email_id")
	private String userEmailId;

	@Column(name = "time_slot")
	private String timeSlot;

	@Column(name = "status")
	private String status;

	@Column(name = "appointment_date")
	private String appointmentDate;

	@JsonIgnore
	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "symptoms")
	private String symptoms;

	@Column(name = "prior_medical_history")
	private String priorMedicalHistory;

}
