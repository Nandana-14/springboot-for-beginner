package com.dewdrops.service;

import java.util.List;

import com.dewdrops.entity.Event;

public interface EventService {
	void saveEvent(Event event);

	List<Event> getAllevents();


	Event getEventByEventId(int eventId);

	void deleteEventByEventId(int eventId);

	Event getEventByEventId(Integer eventId);

	void deleteEventByEventId(Integer eventId);

	
}