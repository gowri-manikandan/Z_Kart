package com.gowri_manikandan.Z_Kart.features.order;

import com.gowri_manikandan.Z_Kart.repository.db.Z_KartDB;
import com.gowri_manikandan.Z_Kart.repository.dto.*;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;
import com.gowri_manikandan.Z_Kart.utils.ValidationUtil;
import java.util.ArrayList;
import java.util.List;

public class OrderModel {
    private final OrderView orderView;
    private final Z_KartDB db = Z_KartDB.getInstance();
    private final SessionManager session = SessionManager.getInstance();

    public OrderModel(OrderView orderView) {
        this.orderView = orderView;
    }

    public void placeOrder(List<CardItem> cartItems, String address) {
        session.requireLogin();
        if (!ValidationUtil.validateOrder(cartItems, db.getAllProducts())) {
            orderView.displayError("Invalid order: check stock or cart.");
            return;
        }

        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;
        for (CardItem cartItem : cartItems) {
            Product product = db.getProductById(cartItem.getProductId());
            OrderItem item = new OrderItem(0, 0, product.getId(), product.getName(), product.getPrice(), cartItem.getQuantity(), product.getModel(), product.getCategory(), product.getBrand());
            orderItems.add(item);
            total += product.getPrice() * cartItem.getQuantity();
            // Reduce stock
            product.setStock(product.getStock() - cartItem.getQuantity());
            db.updateProduct(product);
        }

        Order order = new Order(0, session.getLoggedInCustomer().getId(), orderItems, total, OrderStatus.PENDING, address, System.currentTimeMillis());
        db.addOrder(order);
        // Update orderId in items
        for (OrderItem item : orderItems) {
            item.setOrderId(order.getId());
        }
        // Clear cart
        db.clearCart(session.getLoggedInCustomer().getId());
        orderView.displaySuccess("Order placed successfully. Order ID: " + order.getId());
    }

    public List<Order> getMyOrders() {
        session.requireLogin();
        return db.getOrdersByCustomerId(session.getLoggedInCustomer().getId());
    }

    public List<Order> getAllOrders() {
        session.requireAdminAccess();
        return db.getAllOrders();
    }

    public void updateOrderStatus(long orderId, OrderStatus status) {
        session.requireAdminAccess();
        Order order = db.getOrderById(orderId);
        if (order == null) {
            orderView.displayError("Order not found.");
            return;
        }
        order.setStatus(status);
        // In real DB, update, but since in-memory, it's already updated.
        orderView.displaySuccess("Order status updated.");
    }
}
