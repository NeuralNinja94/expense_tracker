package com.expensetracker.backend.services;
import org.springframework.stereotype.Service;

import com.expensetracker.backend.repositories.ExpenseSheetRepository;

@Service
public class ExpenseSheetService {
    private final ExpenseSheetRepository expenseSheetRepository;

    public ExpenseSheetService(ExpenseSheetRepository expenseSheetRepository) {
        this.expenseSheetRepository = expenseSheetRepository;
    }
    // Methode zum Löschen eines Ausgabenblatts
    public void deleteExpenseSheet(Long sheetId) {
        expenseSheetRepository.deleteById(sheetId);
    }
    //


    
}
