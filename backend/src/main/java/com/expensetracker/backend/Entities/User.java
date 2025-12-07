package com.expensetracker.backend.Entities;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class User {
    @Id
    private Long id;
    private String benutzername;
    private String passwort;
    private LocalDate erstellungsdatum;
    
    

}
