package com.excelr.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.project.entity.Booking;
import com.excelr.project.exception.ResourceNotFoundException;
import com.excelr.project.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	BookingService bookingService;
	@PostMapping
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
		return new ResponseEntity<Booking>(bookingService.createBooking(booking),HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Booking>> getAllBooking(){
		return new ResponseEntity<List<Booking>>(bookingService.getAllBooking(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getBookingById(@PathVariable int id){
		try {
			return new ResponseEntity<Booking>(bookingService.getBookingById(id),HttpStatus.OK);
		}
		catch(ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		try {
			return new ResponseEntity<String>(bookingService.deleteById(id),HttpStatus.OK);
		}
		catch(ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
