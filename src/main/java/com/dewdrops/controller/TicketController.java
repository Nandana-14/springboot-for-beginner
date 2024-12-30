package com.dewdrops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dewdrops.entity.Ticket;
import com.dewdrops.service.TicketService;

@Controller
public class TicketController {
	@Autowired
	TicketService ticketService;

	@GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listtickets", ticketService.getAlltickets());
        return "index";
    }

    @GetMapping("/showNewTicketForm")
    public String showNewTicketForm(Model model) {
    	Ticket ticket = new Ticket();
        model.addAttribute("ticket", ticket);
        return "new_ticket";
    }

    @PostMapping("/saveTicket")
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
    	ticketService.saveTicket(ticket);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{ticketId}")
    public String showFormForUpdate(@PathVariable(value = "ticketId") int ticketId, Model model) {
    	Ticket ticket = ticketService.getTicketByTicketId(ticketId);
        model.addAttribute("ticket", ticket);
        return "update_ticket";
    }

    @GetMapping("/deleteTicket/{ticketId}")
    public String deleteTicket(@PathVariable(value = "ticketId") int ticketId) {
    	ticketService.deleteTicketByTicketId(ticketId);
        return "redirect:/";
    }
}