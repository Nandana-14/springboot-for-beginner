package com.dewdrops.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dewdrops.entity.Event;
import com.dewdrops.repository.EventRepository;

@Service
public abstract class EventServiceImpl implements EventService {
	@Autowired
	EventRepository eventRepository;

	@Override
	public void saveEvent(Event event) {
		if (event.getEventId() == null) {
			eventRepository.save(event);
		} else {
			Event staffUpdate = eventRepository.findById(event.getEventId()).get();
			staffUpdate.setVenueId(event.getVenueId());
			staffUpdate.setOrganizerId(event.getOrganizerId());
			staffUpdate.setName(event.getName());
			staffUpdate.setStartTime(event.getStartTime());
			staffUpdate.setEndTime(event.getEndTime());
			eventRepository.save(staffUpdate);
		}
	}

	@Override
	public List<Event> getAllevents() {
		return eventRepository.findAll();
	}

	@Override
	public Event getEventByEventId(Integer eventId) {
		return eventRepository.findById(eventId).get();

	}

	@Override
	public void deleteEventByEventId(Integer eventId) {
		eventRepository.deleteById(eventId);
	}

	
	}

