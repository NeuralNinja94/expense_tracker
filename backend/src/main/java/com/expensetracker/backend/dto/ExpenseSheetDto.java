package com.expensetracker.backend.dto;



public class ExpenseSheetDto {

    
    private Long id;
    private double budget;
    private String monat;   
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
