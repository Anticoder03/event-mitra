package com.excelr.project.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.project.entity.Event;
@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{
	List<Event> findByEventLocation(String Location);
	List<Event> findByEventType(String Type);
	List<Event> findByPriceLessThanEqual(double price);
	List<Event> findByPriceGreaterThanEqual(double price);
	List<Event> findByDateAfter(LocalDate date);
	List<Event> findByDateBefore(LocalDate date);
	
}
