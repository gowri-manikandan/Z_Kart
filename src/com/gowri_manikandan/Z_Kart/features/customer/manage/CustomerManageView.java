package com.gowri_manikandan.Z_Kart.features.customer.manage;

import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.Scanner;

public class CustomerManageView {
    private final CustomerManageModel customerManageModel;
    private final Scanner scanner = new Scanner(System.in);

    public CustomerManageView() {
        customerManageModel = new CustomerManageModel(this);
    }

    public void displayManageMenu() {
        ConsoleUtil.displayHeader("Customer Management");
        System.out.println("1. Deactivate Customer");
        System.out.println("2. Activate Customer");
        System.out.println("3. Back");
        ConsoleUtil.displaySeparator();
    }

    public void showDeactivateForm() {
        long id = ConsoleUtil.readLong("Enter customer ID to deactivate: ");
        customerManageModel.deactivateCustomer(id);
    }

    public void showActivateForm() {
        long id = ConsoleUtil.readLong("Enter customer ID to activate: ");
        customerManageModel.activateCustomer(id);
    }

    public void displayError(String error) {
        ConsoleUtil.displayError(error);
    }

    public void displaySuccess(String success) {
        ConsoleUtil.displaySuccess(success);
    }
}

