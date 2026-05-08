package com.gowri_manikandan.Z_Kart.repository.dto;

import java.util.regex.Pattern;

public class Customer {
    private long id;
    private String name;
    private String email;
    private String password;
    private long pNumber;
    private String address;
    private Role role;
    private boolean isActive;
    private boolean forcePasswordChange;
    private long createdAt;

    // Default constructor
    public Customer() {}

    // Constructor with parameters
    public Customer(long id, String name, String email, String password, long pNumber, String address, Role role, boolean isActive, boolean forcePasswordChange, long createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.pNumber = pNumber;
        this.address = address;
        this.role = role;
        this.isActive = isActive;
        this.forcePasswordChange = forcePasswordChange;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getpNumber() {
        return pNumber;
    }

    public void setpNumber(long pNumber) {
        this.pNumber = pNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isForcePasswordChange() {
        return forcePasswordChange;
    }

    public void setForcePasswordChange(boolean forcePasswordChange) {
        this.forcePasswordChange = forcePasswordChange;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    // Validation methods
    public boolean validateEmail() {
        if (email == null || email.isEmpty()) return false;
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pNumber=" + pNumber +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", isActive=" + isActive +
                ", forcePasswordChange=" + forcePasswordChange +
                ", createdAt=" + createdAt +
                '}';
    }
}
