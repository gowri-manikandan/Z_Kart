package com.gowri_manikandan.Z_Kart.features.customer;

import com.gowri_manikandan.Z_Kart.repository.dto.Customer;
import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private final CustomerModel customerModel;
    private final Scanner scanner = new Scanner(System.in);

    public CustomerView() {
        customerModel = new CustomerModel(this);
    }

    public void displayCustomerMenu() {
        ConsoleUtil.displayHeader("Customer Management");
        System.out.println("1. View All Customers");
        System.out.println("2. Search Customers");
        System.out.println("3. Back");
        ConsoleUtil.displaySeparator();
    }

    public void showAllCustomers() {
        List<Customer> customers = customerModel.getAllCustomers();
        displayCustomers(customers);
    }

    public void showSearchCustomersForm() {
        String query = ConsoleUtil.readString("Enter search query (name or email): ");
        List<Customer> customers = customerModel.searchCustomers(query);
        displayCustomers(customers);
    }

    private void displayCustomers(List<Customer> customers) {
        if (customers.isEmpty()) {
            ConsoleUtil.displayMessage("No customers found.");
            return;
        }
        ConsoleUtil.displayHeader("Customers");
        for (Customer c : customers) {
            System.out.println("ID: " + c.getId() + ", Name: " + c.getName() + ", Email: " + c.getEmail() + ", Role: " + c.getRole() + ", Active: " + c.isActive());
        }
        ConsoleUtil.displaySeparator();
    }
}
