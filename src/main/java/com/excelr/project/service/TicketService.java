package com.excelr.project.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.project.entity.Ticket;
import com.excelr.project.exception.ResourceNotFoundException;
import com.excelr.project.repository.TicketRepository;
@Service
public class TicketService {
	   @Autowired
	    private TicketRepository ticketRepository;

	   
	

	    public Ticket createTicket(Ticket ticket) {
	        return ticketRepository.save(ticket);
	    }




	    public List<Ticket> getAllTicket() {

	        List<Ticket> tickets = ticketRepository.findAll();

	        if (tickets.isEmpty()) {
	            throw new ResourceNotFoundException("No tickets found.");
	        }

	        return tickets;
	    }




		public Ticket getTicketById(int id) {
			if(ticketRepository.existsById(id)) {
				return ticketRepository.findById(id).orElse(null);
			}
			else {
				throw new ResourceNotFoundException("ticket with id: " + id + " does not exist.");
			}
		}
	
}
