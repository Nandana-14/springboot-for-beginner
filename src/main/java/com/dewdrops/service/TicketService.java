package com.dewdrops.service;

import java.util.List;

import com.dewdrops.entity.Ticket;

public interface TicketService {
	void saveTicket(Ticket ticket);

	List<Ticket> getAlltickets();


	Ticket getEventByTicketId(int ticketId);

	void deleteTicketByTicketId(int ticketId);

	Ticket getTicketByTicketId(Integer ticketId);

	void deleteTicketByTicketId(Integer ticketId);



	
}