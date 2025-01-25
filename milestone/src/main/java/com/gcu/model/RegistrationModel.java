package com.gcu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;


public class RegistrationModel {
    @NotNull(message = "Don't leave blank!")
    @Size(min=2, max=30, message = "First name must be between 2 and 30 characters!")
    private String firstName;
    @NotNull(message = "Don't leave blank!")
    @Size(min=2, max=30, message = "Last name must be between 2 and 30 characters!")
    private String lastName;
    @NotNull(message = "Don't leave blank!")
    @Size(min=2, max=30, message = "Username must be between 2 and 30 characters!")
    private String username;
    @NotNull(message = "Don't leave blank!")
    @Size(min=2, max=30, message = "Password must be between 2 and 30 characters!")
    private String password;
    @NotNull(message = "Don't leave blank!")
    @Size(min=2, max=45, message = "Email must be between 2 and 45 characters!")
    @Email(message = "You must enter a valid email!")
    private String email;
    @NotNull(message = "Don't leave blank!")
    @Pattern(regexp="^(\\d{3}[- .]?){2}\\d{4}$", message = "You must enter a valid phone number!")
    private String phoneNumber;

    public String getFirstName(){
        return this.firstName;
    } 

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    } 
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername(){
        return this.username;
    } 
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    } 
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    } 

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    } 
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
