package com.excelr.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.project.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
