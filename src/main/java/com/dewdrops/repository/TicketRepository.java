package com.dewdrops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dewdrops.entity.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}