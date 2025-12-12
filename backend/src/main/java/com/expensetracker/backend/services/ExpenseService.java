package com.expensetracker.backend.services;
import org.springframework.stereotype.Service;
import com.expensetracker.backend.entities.Expense;
import com.expensetracker.backend.repositories.ExpenseRepository;
import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    // Konstruktor
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    // Methoden zum Verwalten von Ausgaben (CRUD-Operationen) können hier hinzugefügt werden
    public List <Expense> getAllExpensesByUserIds(Long userId, String titel, String kategorie, LocalDate monat){
        // Implementierung zum Abrufen aller Ausgaben eines Benutzers mit optionalen Filtern
        return expenseRepository.findByUserIdAndFilters(userId, titel, kategorie, monat);
        
    }

    public Expense getExpenseById(Long userId, Long expenseId){
        return expenseRepository.findByIdAndUserId(expenseId, userId)
                .orElseThrow(() -> new RuntimeException("Expense not found")); 
}
