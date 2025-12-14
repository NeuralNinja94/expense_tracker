package com.expensetracker.backend.entities;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;






@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @NotBlank
    private String benutzername;
    @NotBlank
    @Size(min = 8)
    private String passwort;
    private LocalDate erstellungsdatum;

    // Getter und Setter
    public Long getId() {
        return id;

    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBenutzername() {
        return benutzername;
    }
    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPasswort() {
        return passwort;
    }
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public LocalDate getErstellungsdatum() {
        return erstellungsdatum;
    }



}

  
