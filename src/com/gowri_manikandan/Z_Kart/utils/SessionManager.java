package com.gowri_manikandan.Z_Kart.utils;

import com.gowri_manikandan.Z_Kart.repository.dto.Customer;
import com.gowri_manikandan.Z_Kart.repository.dto.Role;

public class SessionManager {
    private static SessionManager instance;
    private Customer loggedInCustomer;
    private boolean isLoggedIn;
    private Role role;

    private SessionManager() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void login(Customer customer) {
        this.loggedInCustomer = customer;
        this.isLoggedIn = true;
        this.role = customer.getRole();
    }

    public void logout() {
        this.loggedInCustomer = null;
        this.isLoggedIn = false;
        this.role = null;
    }

    public Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public Role getRole() {
        return role;
    }

    public boolean isAdmin() {
        return isLoggedIn && role == Role.ADMIN;
    }

    public boolean isUser() {
        return isLoggedIn && role == Role.USER;
    }

    public void requireLogin() {
        if (!isLoggedIn) {
            throw new RuntimeException("You must be logged in to perform this action.");
        }
    }

    public void requireAdminAccess() {
        if (!isAdmin()) {
            throw new RuntimeException("Admin access required.");
        }
    }
}