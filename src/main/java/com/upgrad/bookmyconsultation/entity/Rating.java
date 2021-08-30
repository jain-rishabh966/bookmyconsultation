package com.upgrad.bookmyconsultation.entity;

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
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rating")
public class Rating {
	@Id
	@Column(name = "id", nullable = false)
	private String id = UUID.randomUUID().toString();

	@Column(name = "appointment_id")
	private String appointmentId;

	@Column(name = "doctor_id")
	private String doctorId;

	@Column(name = "rating")
	private Integer rating;

	@Column(name = "comments")
	private String comments;
}
