package com.dewdrops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dewdrops.entity.Registration;
import com.dewdrops.service.RegistrationService;

@Controller
public class RegistrationController {
	@Autowired
	RegistrationService registrationService;

	@GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listRegistrations", registrationService.getAllRegistrations());
        return "index";
    }

    @GetMapping("/showNewRegistrationForm")
    public String showNewRegistrationForm(Model model) {
    	Registration registration = new Registration();
        model.addAttribute("registration", registration);
        return "new_registration";
    }

    @PostMapping("/saveRegistration")
    public String saveRegistration(@ModelAttribute("registration") Registration registration) {
    	registrationService.saveRegistration(registration);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "registrationId") int registrationId, Model model) {
    	Registration registration = registrationService.getRegistrationByRegistrationId(registrationId);
        model.addAttribute("registration", registration);
        return "update_registration";
    }

    @GetMapping("/deleteRegistration/{registrationId}")
    public String deleteRegistration(@PathVariable(value = "registrationId") int registrationId) {
    	registrationService.deleteRegistrationByRegistrationId(registrationId);
        return "redirect:/";
    }
}

