package com.expensetracker.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.expensetracker.backend.entities.ExpenseSheet;
import com.expensetracker.backend.services.ExpenseSheetService;


import java.util.List;

@RestController
@RequestMapping("/api/expense-sheets")
public class ExpenseSheetController {

 private final ExpenseSheetService expenseSheetService;

    public ExpenseSheetController(ExpenseSheetService expenseSheetService) {
        this.expenseSheetService = expenseSheetService;
    }  
    //Abrufen aller Ausgabenblätter 
    @GetMapping
    public List<ExpenseSheet> getAllExpenseSheets(@RequestParam(required = false) Long userId, @RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month, @RequestParam(required = false) String title, @RequestParam(required = false) Double budget) {
        return expenseSheetService.getAllExpenseSheets(userId, year, month, title, budget);
    }
    //Abrufen eines Ausgabenblatts nach ID
    @GetMapping("/{sheetId")
    public List<ExpenseSheet> getExpenseSheetsByUserId(@PathVariable Long sheetId) {
        return expenseSheetService.getExpenseSheetsById(sheetId);
    }
    //Erstellen eines neuen Ausgabenblatts
    @PostMapping
    public ExpenseSheet createExpenseSheet(@RequestBody ExpenseSheet expenseSheet) {
        return expenseSheetService.createExpenseSheet(expenseSheet);
    }
    //Aktualisieren eines Ausgabenblatts
    @PutMapping("/{sheetId}")
    public ExpenseSheet updateExpenseSheet(@PathVariable Long sheetId, @RequestBody ExpenseSheet expenseSheet) {
        return expenseSheetService.updateExpenseSheet(sheetId, expenseSheet);
    }
    //Löschen eines Ausgabenblatts
    @DeleteMapping("/{sheetId}")
    public void deleteExpenseSheet(@PathVariable Long sheetId) {
        expenseSheetService.deleteExpenseSheet(sheetId);
    }

    
}

