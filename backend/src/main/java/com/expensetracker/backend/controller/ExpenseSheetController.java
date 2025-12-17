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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.backend.dto.ExpenseSheetDto;
import com.expensetracker.backend.entities.ExpenseSheet;
import com.expensetracker.backend.mapper.ExpenseSheetMapper;
import com.expensetracker.backend.services.ExpenseSheetService;


@RestController
@Validated
@RequestMapping("/api/expense-sheets")
public class ExpenseSheetController {

    private final ExpenseSheetService expenseSheetService;
    private final ExpenseSheetMapper expenseSheetMapper;

    
    public ExpenseSheetController(ExpenseSheetService expenseSheetService, ExpenseSheetMapper expenseSheetMapper) {
        this.expenseSheetService = expenseSheetService;
        this.expenseSheetMapper = expenseSheetMapper;
    }
    
    //Abrufen aller Ausgabenblätter 
    @GetMapping
    public List<ExpenseSheetDto> getAllExpenseSheets(@RequestParam(required = false) Long userId, @RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month, @RequestParam(required = false) String title, @RequestParam(required = false) Double budget) {
        return expenseSheetService.getAllExpenseSheets(userId, year, month, title, budget).stream()
                .map(expenseSheetMapper::toDto)
                .collect(Collectors.toList());
    }
    //Abrufen eines Ausgabenblatts nach ID
    @GetMapping("/{sheetId}")
    public ExpenseSheetDto getExpenseSheetByUserId(@PathVariable @NonNull Long sheetId) {
        return expenseSheetMapper.toDto(expenseSheetService.getExpenseSheetById(sheetId));
    }
    //Erstellen eines neuen Ausgabenblatts
    @PostMapping
    public ExpenseSheetDto createExpenseSheet(@RequestBody @Validated @NonNull ExpenseSheetDto expenseSheetDto) {
        ExpenseSheet expenseSheet = expenseSheetMapper.toEntity(expenseSheetDto);
        return expenseSheetMapper.toDto(expenseSheetService.createExpenseSheet(expenseSheet));
    }
    //Aktualisieren eines Ausgabenblatts
    @PutMapping("/{sheetId}")
    public ExpenseSheetDto updateExpenseSheet(@PathVariable @NonNull Long sheetId, @RequestBody @Validated @NonNull ExpenseSheetDto expenseSheetDto) {
        ExpenseSheet expenseSheet = expenseSheetMapper.toEntity(expenseSheetDto);
        return expenseSheetMapper.toDto(expenseSheetService.updateExpenseSheet(sheetId, expenseSheet));
    }
    //Löschen eines Ausgabenblatts
    @DeleteMapping("/{sheetId}")
    public void deleteExpenseSheet(@PathVariable @NonNull Long sheetId) {
        expenseSheetService.deleteExpenseSheet(sheetId);
    }
    //Wieviel wurde ausgegeben in diesem Ausgabenblatt
    @GetMapping("/{sheetId}/total-expenses")   
    public double getTotalExpenses(@PathVariable @NonNull Long sheetId) {
        return expenseSheetService.getTotalExpenses(sheetId);
    }
    //Überprüfen ob Budget überschritten wurde
    @GetMapping("/{sheetId}/is-budget-exceeded")
    public boolean isBudgetExceeded(@PathVariable @NonNull Long sheetId) {
        return expenseSheetService.isBudgetExceeded(sheetId);
    }
    

    
}

