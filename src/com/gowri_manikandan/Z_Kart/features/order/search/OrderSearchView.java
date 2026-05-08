package com.gowri_manikandan.Z_Kart.features.order.search;

import com.gowri_manikandan.Z_Kart.repository.dto.Order;
import com.gowri_manikandan.Z_Kart.repository.dto.OrderItem;
import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.List;
import java.util.Scanner;

public class OrderSearchView {
    private final OrderSearchModel orderSearchModel;
    private final Scanner scanner = new Scanner(System.in);

    public OrderSearchView() {
        orderSearchModel = new OrderSearchModel(this);
    }

    public void displaySearchMenu() {
        ConsoleUtil.displayHeader("Order Search");
        System.out.println("1. View My Orders");
        System.out.println("2. Search by Status (Admin)");
        System.out.println("3. View All Orders (Admin)");
        System.out.println("4. Back");
        ConsoleUtil.displaySeparator();
    }

    public void showMyOrders() {
        List<Order> orders = orderSearchModel.getMyOrders();
        displayOrders(orders);
    }

    public void showAllOrders() {
        List<Order> orders = orderSearchModel.getAllOrders();
        displayOrders(orders);
    }

    public void showSearchByStatus() {
        String status = ConsoleUtil.readString("Enter status (PENDING, CONFIRMED, etc.): ");
        List<Order> orders = orderSearchModel.searchOrdersByStatus(status);
        displayOrders(orders);
    }

    private void displayOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            ConsoleUtil.displayMessage("No orders found.");
            return;
        }
        ConsoleUtil.displayHeader("Orders");
        for (Order o : orders) {
            System.out.println("Order ID: " + o.getId() + ", Customer ID: " + o.getCustomerId() + ", Amount: " + o.getAmount() + ", Status: " + o.getStatus());
            for (OrderItem item : o.getItems()) {
                System.out.println("  - " + item.getName() + " x" + item.getCount());
            }
        }
        ConsoleUtil.displaySeparator();
    }
}
