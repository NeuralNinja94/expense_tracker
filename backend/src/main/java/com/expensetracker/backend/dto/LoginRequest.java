package com.expensetracker.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank (message = "Benutzername darf nicht leer sein")
    private String benutzername;
    @NotBlank (message = "Passwort darf nicht leer sein")
    private String passwort;

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
    
}
