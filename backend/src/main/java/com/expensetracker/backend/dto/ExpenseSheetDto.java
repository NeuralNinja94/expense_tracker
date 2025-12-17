package com.expensetracker.backend.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ExpenseSheetDto {

    
    private Long id;
    @NotNull
    @DecimalMin("0.1")
    private double budget;
    @NotBlank
    private String monat;   
    @NotNull
    private Long userId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public String getMonat() {
        return monat;
    }
    public void setMonat(String monat) {
        this.monat = monat;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    


    
}
