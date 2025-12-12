package com.expensetracker.backend.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.backend.services.ExpenseService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import com.expensetracker.backend.entities.Expense;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.web.bind.annotation.PatchMapping;


@RestController
@RequestMapping("/api/users/{userId}/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    //Abrufen aller Ausgaben eines Benutzers
    @GetMapping
    public List<Expense> getAllExpensesByUserId(@PathVariable Long userId, @RequestParam(required = false) String titel, @RequestParam(required = false) String kategorie, @RequestParam(required = false) LocalDate monat) {
        return expenseService.getAllExpensesByUserId(userId);
    }
    //Abrufen einer Ausgabe nach ID
    @GetMapping("/{expenseId}")
    public Expense getExpenseById(@PathVariable Long userId, @PathVariable Long expenseId) {
        return expenseService.getExpenseById(userId, expenseId);
    }
    //Neue Ausgabe
    @PostMapping
    public Expense createExpense(@PathVariable Long userId, @RequestBody Expense expense) {
        return expenseService.createExpense(userId, expense);
    }
    //Aktualisieren einer Ausgabe
    @PatchMapping("/{expenseId}")
    public Expense updateExpense(@PathVariable Long userId, @PathVariable Long expenseId, @RequestBody Expense expense) {
        return expenseService.updateExpense(userId, expenseId, expense);
    }
    //Löschen einer Ausgabe
    @DeleteMapping("/{expenseId}")
    public void deleteExpense(@PathVariable Long userId, @PathVariable Long expenseId) {
        expenseService.deleteExpense(userId, expenseId);
    }


    
    



    
    
}
