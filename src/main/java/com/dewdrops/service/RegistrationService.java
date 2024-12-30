package com.dewdrops.service;

import java.util.List;

import com.dewdrops.entity.Registration;

public interface RegistrationService {
	void saveRegistration(Registration registration);

	List<Registration> getAllRegistrations();

	Registration getRegistrationByRegistrationId(int registrationId);

	void deleteRegistrationByRegistrationId(int registrationId);

	Registration getRegistrationByRegistrationId(Integer registrationId);

	void deleteRegistrationByRegistrationId(Integer registrationId);

	
}