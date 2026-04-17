package com.gowri_manikandan.Z_Kart.repository.dto;

public class Customer {
    private long id;
    private String name;
    private String email;
    private long pNumber;
    private String address;
    private enum role {admin,user}
    private boolean isActive ;
    private boolean ForcePasswordChange;
    private long createdAt;

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isForcePasswordChange() {
        return ForcePasswordChange;
    }

    public void setForcePasswordChange(boolean forcePasswordChange) {
        ForcePasswordChange = forcePasswordChange;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
