package com.gowri_manikandan.Z_Kart.features.order.details;

import com.gowri_manikandan.Z_Kart.repository.dto.Order;
import com.gowri_manikandan.Z_Kart.repository.dto.OrderItem;
import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.Scanner;

public class OrderDetailView {
    private final OrderDetailModel orderDetailModel;
    private final Scanner scanner = new Scanner(System.in);

    public OrderDetailView() {
        orderDetailModel = new OrderDetailModel(this);
    }

    public void showOrderDetails(long orderId) {
        Order order = orderDetailModel.getOrderDetails(orderId);
        if (order != null) {
            ConsoleUtil.displayHeader("Order Details");
            System.out.println("Order ID: " + order.getId());
            System.out.println("Customer ID: " + order.getCustomerId());
            System.out.println("Amount: " + order.getAmount());
            System.out.println("Status: " + order.getStatus());
            System.out.println("Address: " + order.getAddress());
            System.out.println("Items:");
            for (OrderItem item : order.getItems()) {
                System.out.println("  - " + item.getName() + " x" + item.getCount() + " @ " + item.getPrice());
            }
            ConsoleUtil.displaySeparator();
        }
    }

    public void displayError(String error) {
        ConsoleUtil.displayError(error);
    }
}

