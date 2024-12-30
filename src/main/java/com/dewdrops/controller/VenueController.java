package com.dewdrops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dewdrops.entity.Venue;
import com.dewdrops.service.VenueService;

@Controller
public class VenueController {
	@Autowired
	VenueService venueService;

	@GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listVenues", venueService.getAllVenues());
        return "index";
    }

    @GetMapping("/showNewVenueForm")
    public String showNewVenueForm(Model model) {
    	Venue venue= new Venue();
        model.addAttribute("venue", venue);
        return "new_venue";
    }

    @PostMapping("/saveVenue")
    public String saveVenue(@ModelAttribute("venue") Venue venue) {
    	venueService.saveVenue(venue);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{venueId}")
    public String showFormForUpdate(@PathVariable(value = "venueId") int venueId, Model model) {
    	Venue venue = venueService.getVenueByVenueId(venueId);
        model.addAttribute("venue", venue);
        return "update_venue";
    }

    @GetMapping("/deleteVenue/{venueId}")
    public String deleteVenue(@PathVariable(value = "venueId") int venueId) {
    	venueService.deleteVenueByVenueId(venueId);
        return "redirect:/";
    }
}