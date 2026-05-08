package com.gowri_manikandan.Z_Kart.features.signup;

import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.Scanner;

public class SignUpView {
    private final SignUpModel model;
    private final Scanner scanner = new Scanner(System.in);

    public SignUpView() {
        model = new SignUpModel(this);
    }

    public void displaySignUpMenu() {
        ConsoleUtil.displayHeader("Sign Up");
        System.out.println("1. Register");
        System.out.println("2. Back");
        ConsoleUtil.displaySeparator();
    }

    public void showSignUpForm() {
        String name = ConsoleUtil.readString("Enter name: ");
        String email = ConsoleUtil.readString("Enter email: ");
        String password = ConsoleUtil.readString("Enter password: ");
        long phone = ConsoleUtil.readLong("Enter phone number: ");
        String address = ConsoleUtil.readString("Enter address: ");
        model.registerCustomer(name, email, password, phone, address);
    }

    public void displayError(String error) {
        ConsoleUtil.displayError(error);
    }

    public void displaySuccess(String success) {
        ConsoleUtil.displaySuccess(success);
    }
}
