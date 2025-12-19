package com.expensetracker.backend.dto;

public class AuthResponse {

    
    private String token;
    private String type = "Bearer";
    private Long userId;
    private String benutzername;

    public AuthResponse(String token, Long userId, String benutzername) {
        this.token = token;
        this.userId = userId;
        this.benutzername = benutzername;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getBenutzername() {
        return benutzername;
    }
    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }
    
}
