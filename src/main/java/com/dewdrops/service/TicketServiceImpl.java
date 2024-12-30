package com.dewdrops.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dewdrops.entity.Ticket;
import com.dewdrops.repository.TicketRepository;

@Service
public abstract class TicketServiceImpl implements TicketService {
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public void saveTicket(Ticket ticket) {
		if (ticket.getTicketId() == null) {
			ticketRepository.save(ticket);
		} else {
			Ticket staffUpdate = ticketRepository.findById(ticket.getTicketId()).get();
			staffUpdate.setEventId(ticket.getEventId());
			staffUpdate.setUserId(ticket.getUserId());
			staffUpdate.setTicketType(ticket.getTicketType());
			staffUpdate.setPrice(ticket.getPrice());
			ticketRepository.save(staffUpdate);
		}
	}

	@Override
	public List<Ticket> getAlltickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket getTicketByTicketId(Integer ticketId) {
		return ticketRepository.findById(ticketId).get();

	}

	@Override
	public void deleteTicketByTicketId(Integer ticketId) {
		ticketRepository.deleteById(ticketId);
	}

	
	}

