package com.upgrad.bookmyconsultation.service;

import com.upgrad.bookmyconsultation.entity.Doctor;
import com.upgrad.bookmyconsultation.entity.Rating;
import com.upgrad.bookmyconsultation.repository.DoctorRepository;
import com.upgrad.bookmyconsultation.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RatingsService {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private RatingsRepository ratingsRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	public void submitRatings(Rating rating) {
		rating.setId(UUID.randomUUID().toString());

		ratingsRepository.save(rating);

		Double avgRating = ratingsRepository
				.findByDoctorId(rating.getDoctorId())
				.stream()
				.collect(Collectors.averagingInt(Rating::getRating));

		Doctor doctor = doctorRepository
				.findById(rating.getDoctorId())
				.get();

		doctor.setRating(avgRating);

		doctorRepository.save(doctor);
	}
}
