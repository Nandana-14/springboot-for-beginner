package com.dewdrops.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dewdrops.entity.Registration;
import com.dewdrops.repository.RegistrationRepository;

@Service
public abstract class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	RegistrationRepository registrationRepository;

	@Override
	public void saveRegistration(Registration registration) {
		if (registration.getRegistrationId() == null) {
			registrationRepository.save(registration);
		} else {
			Registration staffUpdate = registrationRepository.findById(registration.getRegistrationId()).get();
			staffUpdate.setEventId(registration.getEventId());
			staffUpdate.setUserId(registration.getUserId());
			staffUpdate.setRegistrationDate(registration.getRegistrationDate());
			staffUpdate.setStatus(registration.getStatus());
			registrationRepository.save(staffUpdate);
		}
	}

	@Override
	public List<Registration> getAllRegistrations() {
		return registrationRepository.findAll();
	}

	@Override
	public Registration getRegistrationByRegistrationId(Integer registrationId) {
		return registrationRepository.findById(registrationId).get();

	}

	@Override
	public void deleteRegistrationByRegistrationId(Integer registrationId) {
		registrationRepository.deleteById(registrationId);
	}

	
	}

