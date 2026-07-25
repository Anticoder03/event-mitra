package com.excelr.project.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.project.entity.Booking;
import com.excelr.project.exception.ResourceNotFoundException;
import com.excelr.project.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;

	public  Booking createBooking(Booking booking) {
		
		return bookingRepository.save(booking);
	}

	public  List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}

	public  Booking getBookingById(int id) {
		if(bookingRepository.existsById(id)) {
			return bookingRepository.findById(id).orElse(null);
		}
		else {
			throw new ResourceNotFoundException("Booking id: " + id + " does not exist.");
		}
	}

	public  String deleteById(int id) {
		if (bookingRepository.existsById(id)) {
			bookingRepository.deleteById(id);
			return "Booking Deleted";
		}
		else {
			throw new ResourceNotFoundException("Booking id: " + id + " does not exist.");
		}
	}
	
}
