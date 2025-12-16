package com.expensetracker.backend.services;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.expensetracker.backend.entities.Expense;
import com.expensetracker.backend.exception.ResourceNotFoundException;
import com.expensetracker.backend.repositories.ExpenseRepository;






@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    //Methode zum Abrufen aller Ausgaben
    public java.util.List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Methode zum Erstellen einer Ausgabe
    public Expense createExpense(@NonNull Expense expense) {
        return expenseRepository.save(expense);
    }

    // Methode zum Aktualisieren einer Expense
public Expense updateExpense(@NonNull Long expenseId, @NonNull Expense updatedExpense) {

    // 1. Bestehende Expense laden oder Fehler werfen
    Expense existingExpense = expenseRepository.findById(expenseId)
        .orElseThrow(() ->
            new ResourceNotFoundException("Expense not found with id: " + expenseId)
        );

    
    existingExpense.setTitel(updatedExpense.getTitel());
    existingExpense.setBetrag(updatedExpense.getBetrag());
    existingExpense.setKategorie(updatedExpense.getKategorie());
    existingExpense.setDatum(updatedExpense.getDatum());

    
    

    // 3. Speichern und zurückgeben
    return expenseRepository.save(existingExpense);
}
    // Methode zum Abrufen einer Ausgabe nach ID
    public Expense getExpenseById(@NonNull Long expenseId) {
        return expenseRepository.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + expenseId));
    }

     // Methode zum Löschen einer Ausgabe
    public void deleteExpense(@NonNull Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    

    
}
    