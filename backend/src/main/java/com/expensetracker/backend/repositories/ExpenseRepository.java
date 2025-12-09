package com.expensetracker.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.backend.entities.Expense;


public interface  ExpenseRepository extends JpaRepository<Expense, Long> {

   List<Expense> findByUserId(Long userId);
    
}
