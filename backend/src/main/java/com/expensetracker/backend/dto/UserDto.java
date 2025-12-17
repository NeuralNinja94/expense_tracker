package com.expensetracker.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDto {
    
private Long id;
@NotBlank
private String benutzername;

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

    

}
