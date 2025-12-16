package com.expensetracker.backend.services;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.expensetracker.backend.entities.ExpenseSheet;
import com.expensetracker.backend.repositories.ExpenseSheetRepository;



@Service
public class ExpenseSheetService {
    private final ExpenseSheetRepository expenseSheetRepository;

    public ExpenseSheetService(ExpenseSheetRepository expenseSheetRepository) {
        this.expenseSheetRepository = expenseSheetRepository;
    }
    // Methode zum Löschen eines Ausgabenblatts
    public void deleteExpenseSheet(@NonNull Long sheetId) {
        expenseSheetRepository.deleteById(sheetId);
    }
    //Methode zum Aktualisieren eines Ausgabenblatts
    public ExpenseSheet updateExpenseSheet(@NonNull Long sheetId, @NonNull ExpenseSheet updatedExpenseSheet) {
        ExpenseSheet existingExpenseSheet = expenseSheetRepository.findById(sheetId)
                .orElseThrow(() -> new IllegalArgumentException("Ausgabenblatt nicht gefunden mit der ID: " + sheetId));

        existingExpenseSheet.setBudget(updatedExpenseSheet.getBudget());
        existingExpenseSheet.setMonat(updatedExpenseSheet.getMonat());

        return expenseSheetRepository.save(existingExpenseSheet);
    }
    //Methode zum Abrufen eines Ausgabenblatts nach ID
    public ExpenseSheet getExpenseSheetById(@NonNull Long sheetId) {
        return expenseSheetRepository.findById(sheetId)
                .orElseThrow(() -> new IllegalArgumentException("Ausgabenblatt nicht gefunden mit der ID: " + sheetId));
    }
    
    
    //Methode zum Abrufen aller Ausgabenblätter mit optionalen Filtern
    public List<ExpenseSheet> getAllExpenseSheets(Long userId, Integer year, Integer month, String title, Double budget) {
        return expenseSheetRepository.findAll();
    }

    //Neuerstellung eines Ausgabenblatts
    public ExpenseSheet createExpenseSheet(@NonNull ExpenseSheet expenseSheet) {
        return expenseSheetRepository.save(expenseSheet);
    }

    //Methode zur Berechnung der Gesamtausgaben in einem Ausgabenblatt
    public double getTotalExpenses(@NonNull Long sheetId) {
        ExpenseSheet expenseSheet = expenseSheetRepository.findById(sheetId)
                .orElseThrow(() -> new IllegalArgumentException("Ausgabenblatt nicht gefunden mit der ID: " + sheetId));

        return expenseSheet.getExpenses()
                .stream()
                .mapToDouble(expense -> expense.getBetrag())
                .sum();
    }
    //Methode zur Überprüfung, ob das Budget überschritten wurde
    public boolean isBudgetExceeded(@NonNull Long sheetId) {
        ExpenseSheet expenseSheet = expenseSheetRepository.findById(sheetId)
                .orElseThrow(() -> new IllegalArgumentException("Ausgabenblatt nicht gefunden mit der ID: " + sheetId));

        double totalExpenses = getTotalExpenses(sheetId);
        return totalExpenses > expenseSheet.getBudget();
    }
    


    
}
