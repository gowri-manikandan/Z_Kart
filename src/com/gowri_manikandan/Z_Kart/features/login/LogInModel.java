package com.gowri_manikandan.Z_Kart.features.login;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Customer;
import com.gowri_manikandan.Z_Kart.repository.dto.PasswordHistory;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;
import com.gowri_manikandan.Z_Kart.utils.ValidationUtil;
import java.util.List;
import java.util.stream.Collectors;

public class LogInModel {
    private final LogInView logInView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();
    private int loginAttempts = 0;
    private static final int MAX_LOGIN_ATTEMPTS = 3;

    public LogInModel(LogInView logInView) {
        this.logInView = logInView;
    }

    public boolean login(String email, String password) {
        if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
            logInView.displayError("Account locked due to too many failed attempts.");
            return false;
        }

        Customer customer = db.getCustomerByEmail(email);
        if (customer == null || !customer.getPassword().equals(password) || !customer.isActive()) {
            loginAttempts++;
            logInView.displayError("Invalid credentials or account inactive.");
            return false;
        }

        if (customer.isForcePasswordChange()) {
            logInView.displayMessage("Password change required.");
            if (!changePassword(customer)) {
                return false;
            }
        }

        session.login(customer);
        loginAttempts = 0;
        logInView.displaySuccess("Login successful.");
        return true;
    }

    public void logout() {
        session.logout();
        logInView.displaySuccess("Logged out successfully.");
    }

    public boolean changePassword(Customer customer) {
        String newPassword = logInView.getNewPassword();
        if (!ValidationUtil.validatePassword(newPassword)) {
            logInView.displayError("Password must be at least 8 characters with uppercase, lowercase, number, and special character.");
            return false;
        }

        List<PasswordHistory> history = db.getPasswordHistoryByCustomerId(customer.getId());
        List<String> recentPasswords = history.stream()
                .sorted((a, b) -> Long.compare(b.getChangedAt(), a.getChangedAt()))
                .limit(3)
                .map(PasswordHistory::getPassword)
                .collect(Collectors.toList());

        if (ValidationUtil.isPasswordReused(newPassword, recentPasswords)) {
            logInView.displayError("Cannot reuse last 3 passwords.");
            return false;
        }

        customer.setPassword(newPassword);
        customer.setForcePasswordChange(false);
        db.updateCustomer(customer);
        db.addPasswordHistory(new PasswordHistory(0, customer.getId(), newPassword, System.currentTimeMillis()));
        logInView.displaySuccess("Password changed successfully.");
        return true;
    }

    public boolean isLoggedIn() {
        return session.isLoggedIn();
    }

    public Customer getLoggedInCustomer() {
        return session.getLoggedInCustomer();
    }
}
