package com.expensetracker.backend.entities;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Long id;
    @NotBlank
    private String benutzername;
    @NotBlank
    @Size(min = 8)
    private String passwort;
    private LocalDate erstellungsdatum;

    

    

}

  
