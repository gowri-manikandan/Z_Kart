package com.gowri_manikandan.Z_Kart.features.order;

import com.gowri_manikandan.Z_Kart.repository.dto.Order;
import com.gowri_manikandan.Z_Kart.repository.dto.OrderItem;
import com.gowri_manikandan.Z_Kart.repository.dto.OrderStatus;
import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    private final OrderModel orderModel;
    private final Scanner scanner = new Scanner(System.in);

    public OrderView() {
        orderModel = new OrderModel(this);
    }

    public void displayOrderMenu() {
        ConsoleUtil.displayHeader("Order Management");
        System.out.println("1. Place Order");
        System.out.println("2. View My Orders");
        System.out.println("3. Back");
        ConsoleUtil.displaySeparator();
    }

    public void displayAdminOrderMenu() {
        ConsoleUtil.displayHeader("Admin Order Management");
        System.out.println("1. View All Orders");
        System.out.println("2. Update Order Status");
        System.out.println("3. Back");
        ConsoleUtil.displaySeparator();
    }

    public void showPlaceOrder(List<com.gowri_manikandan.Z_Kart.repository.dto.CardItem> cartItems) {
        if (cartItems.isEmpty()) {
            displayError("Cart is empty.");
            return;
        }
        String address = ConsoleUtil.readString("Enter delivery address: ");
        orderModel.placeOrder(cartItems, address);
    }

    public void showMyOrders() {
        List<Order> orders = orderModel.getMyOrders();
        displayOrders(orders);
    }

    public void showAllOrders() {
        List<Order> orders = orderModel.getAllOrders();
        displayOrders(orders);
    }

    public void showUpdateOrderStatusForm() {
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
        orderModel.updateOrderStatus(orderId, status);
    }

    private void displayOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            ConsoleUtil.displayMessage("No orders found.");
            return;
        }
        ConsoleUtil.displayHeader("Orders");
        for (Order o : orders) {
            System.out.println("Order ID: " + o.getId() + ", Customer ID: " + o.getCustomerId() + ", Amount: " + o.getAmount() + ", Status: " + o.getStatus() + ", Address: " + o.getAddress());
            for (OrderItem item : o.getItems()) {
                System.out.println("  - " + item.getName() + " x" + item.getCount() + " @ " + item.getPrice());
            }
        }
        ConsoleUtil.displaySeparator();
    }

    public void displayError(String error) {
        ConsoleUtil.displayError(error);
    }

    public void displaySuccess(String success) {
        ConsoleUtil.displaySuccess(success);
    }
}
