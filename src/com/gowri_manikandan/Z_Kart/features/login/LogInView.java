package com.gowri_manikandan.Z_Kart.features.login;

import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.Scanner;

public class LogInView {
    private final LogInModel logInModel;

    public LogInView()
    {
        logInModel = new LogInModel(this);
    }

    public void displayLoginMenu() {
        ConsoleUtil.displayHeader("Login");
        System.out.println("1. Login");
        System.out.println("2. Back");
        ConsoleUtil.displaySeparator();
    }

    public void showLoginForm() {
        String email = ConsoleUtil.readString("Enter email: ");
        String password = ConsoleUtil.readString("Enter password: ");
        if (!logInModel.login(email, password)) {
            showLoginForm();
        }
    }

    public void showLogout() {
        logInModel.logout();
    }

    public void showChangePassword() {
        if (!logInModel.isLoggedIn()) {
            displayError("You must be logged in to change password.");
            return;
        }
        logInModel.changePassword(logInModel.getLoggedInCustomer());
    }

    public String getNewPassword() {
        return ConsoleUtil.readString("Enter new password: ");
    }

    public void displayError(String error) {
        ConsoleUtil.displayError(error);
    }

    public void displaySuccess(String success) {
        ConsoleUtil.displaySuccess(success);
    }

    public void displayMessage(String message) {
        ConsoleUtil.displayMessage(message);
    }
}
