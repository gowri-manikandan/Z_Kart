package com.gowri_manikandan.Z_Kart.features.customer.search;

import com.gowri_manikandan.Z_Kart.repository.dto.Customer;
import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.List;
import java.util.Scanner;

public class CustomerSearchView {
    private final CustomerSearchModel customerSearchModel;
    private final Scanner scanner = new Scanner(System.in);

    public CustomerSearchView() {
        customerSearchModel = new CustomerSearchModel(this);
    }

    public void displaySearchMenu() {
        ConsoleUtil.displayHeader("Customer Search");
        System.out.println("1. Search Customers");
        System.out.println("2. View All Customers");
        System.out.println("3. Back");
        ConsoleUtil.displaySeparator();
    }

    public void showSearchForm() {
        String query = ConsoleUtil.readString("Enter search query (name or email): ");
        List<Customer> customers = customerSearchModel.searchCustomers(query);
        displayCustomers(customers);
    }

    public void showAllCustomers() {
        List<Customer> customers = customerSearchModel.getAllCustomers();
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

