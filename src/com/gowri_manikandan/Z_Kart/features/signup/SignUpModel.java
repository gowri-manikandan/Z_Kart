package com.gowri_manikandan.Z_Kart.features.signup;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.Customer;
import com.gowri_manikandan.Z_Kart.repository.dto.PasswordHistory;
import com.gowri_manikandan.Z_Kart.repository.dto.Role;
import com.gowri_manikandan.Z_Kart.utils.ValidationUtil;

public class SignUpModel {
    private final SignUpView signUpView;
    private final Z_KartDB db = Z_KartDB.getInstance();

    public SignUpModel(SignUpView signUpView) {
        this.signUpView = signUpView;
    }

    public boolean registerCustomer(String name, String email, String password, long phone, String address) {
        if (!ValidationUtil.validateEmail(email)) {
            signUpView.displayError("Invalid email format.");
            return false;
        }

        if (db.getCustomerByEmail(email) != null) {
            signUpView.displayError("Email already exists.");
            return false;
        }

        if (!ValidationUtil.validatePassword(password)) {
            signUpView.displayError("Password must be at least 8 characters with uppercase, lowercase, number, and special character.");
            return false;
        }

        Customer customer = new Customer(0, name, email, password, phone, address, Role.USER, true, false, System.currentTimeMillis());
        db.addCustomer(customer);
        db.addPasswordHistory(new PasswordHistory(0, customer.getId(), password, System.currentTimeMillis()));
        signUpView.displaySuccess("Registration successful.");
        return true;
    }
}
