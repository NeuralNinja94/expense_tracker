package com.expensetracker.backend.dto;


public class ExpenseDto {


    private Long id;
    private String titel;
    private Double betrag;
    private String kategorie;
    private String datum;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public Double getBetrag() {
        return betrag;
    }
    public void setBetrag(Double betrag) {
        this.betrag = betrag;
    }

    public String getKategorie() {
        return kategorie;
    }
    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getDatum() {
        return datum;
    }
    public void setDatum(String datum) {
        this.datum = datum;
    }

}
