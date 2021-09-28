package com.upgrad.bookmyconsultation.service;

import com.upgrad.bookmyconsultation.entity.Appointment;
import com.upgrad.bookmyconsultation.exception.InvalidInputException;
import com.upgrad.bookmyconsultation.exception.ResourceUnAvailableException;
import com.upgrad.bookmyconsultation.exception.SlotUnavailableException;
import com.upgrad.bookmyconsultation.repository.AppointmentRepository;
import com.upgrad.bookmyconsultation.repository.UserRepository;
import com.upgrad.bookmyconsultation.util.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private UserRepository userRepository;

	public String appointment(Appointment appointment) throws SlotUnavailableException, InvalidInputException {
		ValidationUtils.validate(appointment);

		/* Using the spring functionality to get doctor by Doctor id and Time Slot and Appointment Date */
		Appointment existingAppointment = appointmentRepository.findByDoctorIdAndTimeSlotAndAppointmentDate(
				appointment.getDoctorId(), appointment.getTimeSlot(), appointment.getAppointmentDate());

		if (existingAppointment != null) {
			throw new SlotUnavailableException();
		}

		appointmentRepository.save(appointment);
		return appointment.getAppointmentId();
	}

	public Appointment getAppointment(String appointmentId) {
		return Optional.ofNullable(appointmentRepository.findById(appointmentId)).get()
				.orElseThrow(ResourceUnAvailableException::new);
	}

	public List<Appointment> getAppointmentsForUser(String userId) {
		return appointmentRepository.findByUserId(userId);
	}
}
