package com.gowri_manikandan.Z_Kart.features.order.manage;

import com.gowri_manikandan.Z_Kart.repository.dto.OrderStatus;
import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.Scanner;

public class OrderManageView {
    private final OrderManageModel orderManageModel;
    private final Scanner scanner = new Scanner(System.in);

    public OrderManageView() {
        orderManageModel = new OrderManageModel(this);
    }

    public void displayManageMenu() {
        ConsoleUtil.displayHeader("Order Management");
        System.out.println("1. Update Order Status");
        System.out.println("2. Back");
        ConsoleUtil.displaySeparator();
    }

    public void showUpdateStatusForm() {
        long orderId = ConsoleUtil.readLong("Enter order ID: ");
        System.out.println("Select status:");
        System.out.println("1. PENDING");
        System.out.println("2. CONFIRMED");
        System.out.println("3. SHIPPED");
        System.out.println("4. DELIVERED");
        System.out.println("5. CANCELLED");
        int choice = ConsoleUtil.readInt("Enter choice: ");
        OrderStatus status;
        switch (choice) {
            case 1: status = OrderStatus.PENDING; break;
            case 2: status = OrderStatus.CONFIRMED; break;
            case 3: status = OrderStatus.SHIPPED; break;
            case 4: status = OrderStatus.DELIVERED; break;
            case 5: status = OrderStatus.CANCELLED; break;
            default: displayError("Invalid choice."); return;
        }
        orderManageModel.updateOrderStatus(orderId, status);
    }

    public void displayError(String error) {
        ConsoleUtil.displayError(error);
    }

    public void displaySuccess(String success) {
        ConsoleUtil.displaySuccess(success);
    }
}

