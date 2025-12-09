package com.expensetracker.backend.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ExpenseSheet {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private double budget;
private LocalDate monat;

@ManyToOne
private User user;

@OneToMany
private List<Expense> expenses;


    
}
