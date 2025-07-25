package com.gcu.model;

import jakarta.validation.constraints.NotNull;

/**
 * Class representing a model for user login
 */
public class LoginModel {
	
    @NotNull
    private String username;
    
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
