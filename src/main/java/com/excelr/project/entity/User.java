package com.excelr.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    private String user_name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String gender;

    private Integer age;

    private String role;
    @PrePersist
    public void prePersist() {
        if (role == null || role.isBlank()) {
            role = "USER";
        }
    }
    

}