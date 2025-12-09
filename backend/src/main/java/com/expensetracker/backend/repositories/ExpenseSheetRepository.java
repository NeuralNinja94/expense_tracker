package com.expensetracker.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.backend.entities.ExpenseSheet;

public interface ExpenseSheetRepository extends JpaRepository<ExpenseSheet, Long> {
    
}
