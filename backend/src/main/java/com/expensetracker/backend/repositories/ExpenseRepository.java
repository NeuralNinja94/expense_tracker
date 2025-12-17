package com.expensetracker.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.backend.entities.Expense;



public interface  ExpenseRepository extends JpaRepository<Expense, Long> {
   // Zeigt alle Ausgaben eines bestimmten Users an
   List<Expense> findByUser_Id(Long userId);
   // Zeigt alle Ausgaben eines bestimmten Users in einem bestimmten Zeitraum an
   List<Expense> findByUser_IdAndDatumBetween(Long userId, java.time.LocalDate startDatum, java.time.LocalDate endDatum);
   // Zeigt alle Ausgaben eines bestimmten Users in einer bestimmten Kategorie an
   List<Expense> findByUser_IdAndKategorie(Long userId, String kategorie);
   // Zeigt alle Ausgaben eines bestimmten Users mit einem bestimmten Titel und Kategorie an
   List<Expense> findByUser_IdAndKategorieAndTitel(Long userId, String kategorie, String titel);
   // Zeigt eine bestimmte Ausgabe eines bestimmten Users an
   List<Expense> findByIdAndUserId(Long id, Long userId);



    
}
