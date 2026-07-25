package com.excelr.project.service;

import java.time.LocalDate;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.project.entity.Event;
import com.excelr.project.exception.ResourceNotFoundException;
import com.excelr.project.repository.EventRepository;

@Service
public class EventService {
	@Autowired
	EventRepository eventRepository;

	public  Event addEvent(Event event) {
		return eventRepository.save(event);
	}

	public List<Event> getAllEvent() {
		return eventRepository.findAll();
	}

	public Event getEventById(int id) {
		if(eventRepository.existsById(id)) {
			return eventRepository.findById(id).orElse(null);
		}
		else {
			throw new ResourceNotFoundException("Event with id: " + id + " does not exist.");
		}
	}
	 
	
	public List<Event> getEventsByLocation(String location) {

	    List<Event> events = eventRepository.findByEventLocation(location);

	    if(events.isEmpty()) {
	        throw new ResourceNotFoundException("No events found in " + location);
	    }

	    return events;
	}

	 
	
	public List<Event> getEventsByType(String type) {

	    List<Event> events = eventRepository.findByEventType(type);

	    if(events.isEmpty()) {
	        throw new ResourceNotFoundException("No " + type + " events found.");
	    }

	    return events;
	}

	 
	
	public List<Event> getEventsLessThanPrice(double price) {

	    List<Event> events = eventRepository.findByPriceLessThanEqual(price);

	    if(events.isEmpty()) {
	        throw new ResourceNotFoundException("No events found below price " + price);
	    }

	    return events;
	}

	 
	
	public List<Event> getEventsGreaterThanPrice(double price) {

	    List<Event> events = eventRepository.findByPriceGreaterThanEqual(price);

	    if(events.isEmpty()) {
	        throw new ResourceNotFoundException("No events found above price " + price);
	    }

	    return events;
	}

	 
	public List<Event> getEventsAfterDate(LocalDate date) {

	    List<Event> events = eventRepository.findByDateAfter(date);

	    if(events.isEmpty()) {
	        throw new ResourceNotFoundException("No events found after " + date);
	    }

	    return events;
	}

	 

	public List<Event> getEventsBeforeDate(LocalDate date) {

	    List<Event> events = eventRepository.findByDateBefore(date);

	    if(events.isEmpty()) {
	        throw new ResourceNotFoundException("No events found before " + date);
	    }

	    return events;
	}

	public Event updateEvent(int id, Event newdata) {
		if(eventRepository.existsById(id)) {
			Event dbEvent = getEventById(id);
			dbEvent.setDate(newdata.getDate());
			dbEvent.setEventLocation(newdata.getEventLocation());
			dbEvent.setEventName(newdata.getEventName());
			dbEvent.setMaxCap(newdata.getMaxCap());
			dbEvent.setPrice(newdata.getPrice());
			
			eventRepository.save(dbEvent);
			return dbEvent;
			
		}
		else {
			throw new ResourceNotFoundException("Event With id: " + id + " does not exist.");
		}
	}


	public String deleteEvent(int id) {
		if(eventRepository.existsById(id)) {
			eventRepository.deleteById(id);
			return "Event Deleted.";
		}
		else {
			throw new ResourceNotFoundException("Event With id: " + id + " does not exist.");
		}
	}
	

	
	
	
}
