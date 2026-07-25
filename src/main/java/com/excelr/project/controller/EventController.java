package com.excelr.project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.project.entity.Event;
import com.excelr.project.exception.ResourceNotFoundException;
import com.excelr.project.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	@Autowired
	EventService eventService;
	
	@PostMapping
	public ResponseEntity<Event> addEvent(@RequestBody Event event){
		return new ResponseEntity<Event>(eventService.addEvent(event),HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Event>> getAllEvent(){
		return new ResponseEntity<List<Event>>(eventService.getAllEvent(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getEventById(@PathVariable int id){
		try {
			return new ResponseEntity<Event>(eventService.getEventById(id),HttpStatus.OK);
		}
		catch(ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/location/{location}")
	public ResponseEntity<?> getEventsByLocation(@PathVariable String location) {
	    try {
	        return new ResponseEntity<List<Event>>(
	                eventService.getEventsByLocation(location),
	                HttpStatus.OK);
	    } catch (ResourceNotFoundException e) {
	        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}

	@GetMapping("/type/{type}")
	public ResponseEntity<?> getEventsByType(@PathVariable String type) {
	    try {
	        return new ResponseEntity<List<Event>>(
	                eventService.getEventsByType(type),
	                HttpStatus.OK);
	    } catch (ResourceNotFoundException e) {
	        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}

	@GetMapping("/price/lessthan/{price}")
	public ResponseEntity<?> getEventsLessThanPrice(@PathVariable double price) {
	    try {
	        return new ResponseEntity<List<Event>>(
	                eventService.getEventsLessThanPrice(price),
	                HttpStatus.OK);
	    } catch (ResourceNotFoundException e) {
	        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}

	@GetMapping("/price/greaterthan/{price}")
	public ResponseEntity<?> getEventsGreaterThanPrice(@PathVariable double price) {
	    try {
	        return new ResponseEntity<List<Event>>(
	                eventService.getEventsGreaterThanPrice(price),
	                HttpStatus.OK);
	    } catch (ResourceNotFoundException e) {
	        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}

	@GetMapping("/after/{date}")
	public ResponseEntity<?> getEventsAfterDate(@PathVariable LocalDate date) {
	    try {
	        return new ResponseEntity<List<Event>>(
	                eventService.getEventsAfterDate(date),
	                HttpStatus.OK);
	    } catch (ResourceNotFoundException e) {
	        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}

	@GetMapping("/before/{date}")
	public ResponseEntity<?> getEventsBeforeDate(@PathVariable LocalDate date) {
	    try {
	        return new ResponseEntity<List<Event>>(
	                eventService.getEventsBeforeDate(date),
	                HttpStatus.OK);
	    } catch (ResourceNotFoundException e) {
	        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEvent(@PathVariable int id, @RequestBody Event newdata){
		try {
			return new ResponseEntity<Event>(eventService.updateEvent(id,newdata),HttpStatus.OK);
		}
		catch(ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable int id){
		try {
			return new ResponseEntity<String>(eventService.deleteEvent(id),HttpStatus.OK);
		}
		catch(ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		
		}
	}
	
	
}
