 package com.excelr.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.project.entity.Ticket;
import com.excelr.project.exception.ResourceNotFoundException;
import com.excelr.project.service.TicketService;
@RestController
@RequestMapping("/ticket")
public class TicketController {

		@Autowired
		TicketService ticketService;
		
		@PostMapping
		public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
			return new ResponseEntity<Ticket>(ticketService.createTicket(ticket),HttpStatus.CREATED);
		}
		@GetMapping
		public ResponseEntity<?> getAllTicket() {

		    try {
		        return new ResponseEntity<List<Ticket>>(
		                ticketService.getAllTicket(),
		                HttpStatus.OK);
		    } catch (ResourceNotFoundException e) {
		        return new ResponseEntity<String>(
		                e.getMessage(),
		                HttpStatus.NOT_FOUND);
		    }
		}
		@GetMapping("/{id}")
		public ResponseEntity<?> getTicketById(@PathVariable int id) {

		    try {
		        return new ResponseEntity<Ticket>(
		                ticketService.getTicketById(id),
		                HttpStatus.OK);
		    } catch (ResourceNotFoundException e) {
		        return new ResponseEntity<String>(
		                e.getMessage(),
		                HttpStatus.NOT_FOUND);
		    }
		}
}
