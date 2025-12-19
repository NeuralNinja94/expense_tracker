package com.expensetracker.backend.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignupRequest {
    
    @NotBlank(message = "Benutzername darf nicht leer sein")
    private String benutzername;
    
    @NotBlank(message = "Email ist erforderlich")
    @Email(message = "Bitte richtige E-mail-Adresse eingeben")
    
    private String email;
    
    @NotBlank(message = "Passwort ist erforderlich")
    @Size(min = 8, message = "Passwort muss mindestens 8 Zeichen lang sein")
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

   

}