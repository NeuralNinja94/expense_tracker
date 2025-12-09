package com.expensetracker.backend.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.backend.entities.ExpenseSheet;


public interface ExpenseSheetRepository extends JpaRepository<ExpenseSheet, Long> {
    //Zeigt ein bestimmtes Sheet für bestimmten Monat + User
    List<ExpenseSheet> findByMonatAndUserId(LocalDate monat, Long userId);

    //Zeigt alle Sheets eines bestimmten Users an
    List<ExpenseSheet> findByUserId(Long userId);

    //Zeigt das aktuellste Sheet eines Users an
    List<ExpenseSheet> findByUserIdOrderByMonatDesc(Long userId);
    
    //Prüft ob ein Sheet für bestimmten Monat + User existiert
    boolean existsByMonatAndUserId(LocalDate monat, Long userId);


    // Zeigt alle Sheets eines Users eines bestimmten jahres
    List<ExpenseSheet> findByMonatBetweenAndUserIdOrderByMonatAsc(LocalDate startMonat, LocalDate endMonat, Long userId);




}
