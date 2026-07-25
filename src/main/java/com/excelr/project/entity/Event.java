package com.excelr.project.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer event_id;

    private String eventName;

    private String eventType;

    private String eventLocation;

    private Integer maxCap;

    private Double price;
    
    private LocalDate date;
    
    

}