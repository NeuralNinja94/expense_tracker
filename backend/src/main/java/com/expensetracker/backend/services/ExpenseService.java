package com.expensetracker.backend.services;
import org.springframework.stereotype.Service;
import com.expensetracker.backend.entities.Expense;
import com.expensetracker.backend.repositories.ExpenseRepository;




@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Methode zum Erstellen einer Ausgabe
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Methode zum Aktualisieren einer Ausgabe
    public Expense updateExpense(Long expenseId, Expense updatedExpense) {
        Expense existingExpense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + expenseId));

        existingExpense.setTitel(updatedExpense.getTitel());
        existingExpense.setBetrag(updatedExpense.getBetrag());
        existingExpense.setKategorie(updatedExpense.getKategorie());
        existingExpense.setDatum(updatedExpense.getDatum());

        return expenseRepository.save(existingExpense);
    }
    
    
    // Methode zum Löschen einer Ausgabe
    public void deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    

    
}
    