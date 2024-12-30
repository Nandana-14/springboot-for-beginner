package com.dewdrops.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dewdrops.entity.Venue;
import com.dewdrops.repository.VenueRepository;

@Service
public abstract class VenueServiceImpl implements VenueService {
	@Autowired
	VenueRepository venueRepository;

	@Override
	public void saveVenue(Venue venue) {
		if (venue.getVenueId() == null) {
			venueRepository.save(venue);
		} else {
			Venue staffUpdate = venueRepository.findById(venue.getVenueId()).get();
			staffUpdate.setName(venue.getName());
			staffUpdate.setAddress(venue.getAddress());
			staffUpdate.setCapacity(venue.getCapacity());
			venueRepository.save(staffUpdate);
		}
	}

	@Override
	public List<Venue> getAllVenues() {
		return venueRepository.findAll();
	}

	@Override
	public Venue getVenueByVenueId(Integer venueId) {
		return venueRepository.findById(venueId).get();

	}

	@Override
	public void deleteVenueByVenueId(Integer venueId) {
		venueRepository.deleteById(venueId);
	}

	
}
