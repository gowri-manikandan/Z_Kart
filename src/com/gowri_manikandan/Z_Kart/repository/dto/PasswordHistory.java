package com.gowri_manikandan.Z_Kart.repository.dto;

public class PasswordHistory {
    private long id;
    private long customerId;
    private String password;
    private long changedAt;

    // Default constructor
    public PasswordHistory() {}

    // Constructor with parameters
    public PasswordHistory(long id, long customerId, String password, long changedAt) {
        this.id = id;
        this.customerId = customerId;
        this.password = password;
        this.changedAt = changedAt;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(long changedAt) {
        this.changedAt = changedAt;
    }

    @Override
    public String toString() {
        return "PasswordHistory{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", password='" + password + '\'' +
                ", changedAt=" + changedAt +
                '}';
    }
}
