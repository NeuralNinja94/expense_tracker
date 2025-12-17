package com.expensetracker.backend.controller;


import java.util.List;
import java.util.stream.Collectors;

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

import com.expensetracker.backend.dto.ExpenseDto;
import com.expensetracker.backend.entities.Expense;
import com.expensetracker.backend.mapper.ExpenseMapper;
import com.expensetracker.backend.services.ExpenseService;







@RestController
@Validated
@RequestMapping("/api/users/{userId}/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    private final ExpenseMapper expenseMapper;

    public ExpenseController(ExpenseService expenseService, ExpenseMapper expenseMapper) {
        this.expenseService = expenseService;
        this.expenseMapper = expenseMapper;
    }
    //Abrufen aller Ausgaben
    @GetMapping
    public List<ExpenseDto> getAllExpenses() {
        return expenseService.getAllExpenses().stream()
                .map(expenseMapper::toDto)
                .collect(Collectors.toList());
    }
    //Abrufen einer Ausgabe nach Id
    @GetMapping("/{expenseId}")
    public ExpenseDto getExpenseById(@PathVariable @NonNull Long expenseId) {
        return expenseMapper.toDto(expenseService.getExpenseById(expenseId));
    }

    //Methode zum erstellen einer Ausgabe
    @PostMapping
    public ExpenseDto createExpense(@RequestBody @Validated @NonNull ExpenseDto expenseDto) {
        Expense expense = expenseMapper.toEntity(expenseDto);
        return expenseMapper.toDto(expenseService.createExpense(expense));
    }

    //Methode zum Aktualisieren einer Ausgabe
    @PutMapping("/{expenseId}")
    public ExpenseDto updateExpense(@PathVariable @NonNull Long expenseId, @RequestBody @Validated @NonNull ExpenseDto expenseDto) {
        Expense expense = expenseMapper.toEntity(expenseDto);
        return expenseMapper.toDto(expenseService.updateExpense(expenseId, expense));
    }
    //Methode zum Löschen einer Ausgabe
    @DeleteMapping("/{expenseId}")
    public void deleteExpense(@PathVariable @NonNull Long expenseId) {
        expenseService.deleteExpense(expenseId);
    }
    
    


}


    
    



    
    

