package com.dewdrops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dewdrops.entity.Event;
import com.dewdrops.service.EventService;

@Controller
public class EventController {
	@Autowired
    EventService eventService;

	@GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEvents", eventService.getAllevents());
        return "index";
    }

    @GetMapping("/showNewEventForm")
    public String showNewEventForm(Model model) {
    	Event event = new Event();
        model.addAttribute("event", event);
        return "new_event";
    }

    @PostMapping("/saveEvent")
    public String saveEvent(@ModelAttribute("event") Event event) {
    	eventService.saveEvent(event);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{eventId}")
    public String showFormForUpdate(@PathVariable(value = "eventId") int eventId, Model model) {
    	Event event = eventService.getEventByEventId(eventId);
        model.addAttribute("event", event);
        return "update_event";
    }

    @GetMapping("/deleteEvent/{eventId}")
    public String deleteEvent(@PathVariable(value = "eventId") int eventId) {
    	eventService.deleteEventByEventId(eventId);
        return "redirect:/";
    }
}

