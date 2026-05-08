package com.gowri_manikandan.Z_Kart.features.customer.details;

import com.gowri_manikandan.Z_Kart.repository.dto.Customer;
import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.Scanner;

public class CustomerDetailView {
    private final CustomerDetailModel customerDetailModel;
    private final Scanner scanner = new Scanner(System.in);

    public CustomerDetailView() {
        customerDetailModel = new CustomerDetailModel(this);
    }

    public void showCustomerDetails(long customerId) {
        Customer customer = customerDetailModel.getCustomerDetails(customerId);
        if (customer != null) {
            ConsoleUtil.displayHeader("Customer Details");
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getpNumber());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Role: " + customer.getRole());
            System.out.println("Active: " + customer.isActive());
            ConsoleUtil.displaySeparator();
        }
    }

    public void displayError(String error) {
        ConsoleUtil.displayError(error);
    }
}

