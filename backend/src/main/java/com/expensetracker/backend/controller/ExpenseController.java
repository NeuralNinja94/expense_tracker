package com.expensetracker.backend.controller;


import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.backend.entities.Expense;
import com.expensetracker.backend.services.ExpenseService;






@RestController
@Validated
@RequestMapping("/api/users/{userId}/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    //Abrufen aller Ausgaben
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }
    //Abrufen einer Ausgabe nach Id
    @GetMapping("/{expenseId}")
    public Expense getExpenseById(@PathVariable @NonNull Long expenseId) {
        return expenseService.getExpenseById(expenseId);
    }

    //Methode zum erstellen einer Ausgabe
    @PostMapping
    public Expense createExpense(@RequestBody @Validated @NonNull Expense expense) {
        return expenseService.createExpense(expense);
    }

    //Methode zum Aktualisieren einer Ausgabe
    @PutMapping("/{expenseId}")
    public Expense updateExpense(@PathVariable @NonNull Long expenseId, @RequestBody @Validated @NonNull Expense expense) {
        return expenseService.updateExpense(expenseId, expense);
    }
    //Methode zum Löschen einer Ausgabe
    @DeleteMapping("/{expenseId}")
    public void deleteExpense(@PathVariable @NonNull Long expenseId) {
        expenseService.deleteExpense(expenseId);
    }
    
    //


}


    
    



    
    

