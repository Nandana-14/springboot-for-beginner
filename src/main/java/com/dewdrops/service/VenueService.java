package com.dewdrops.service;

import java.util.List;

import com.dewdrops.entity.Venue;
import com.dewdrops.service.VenueService;

public interface VenueService {
	void saveUser(Venue venue);

	List<Venue> getAllVenues();

	Venue getVenueByVenueId(Integer venueId);

	void deleteVenueByVenueId(Integer venueId);

	void saveVenue(Venue venue);
}