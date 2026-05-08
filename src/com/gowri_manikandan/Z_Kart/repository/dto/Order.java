package com.gowri_manikandan.Z_Kart.repository.dto;

import java.util.List;

public class Order {
    private long id;
    private long customerId;
    private List<OrderItem> items;
    private double amount;
    private OrderStatus status;
    private String address;
    private long createdAt;

    // Default constructor
    public Order() {}

    // Constructor with parameters
    public Order(long id, long customerId, List<OrderItem> items, double amount, OrderStatus status, String address, long createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
        this.amount = amount;
        this.status = status;
        this.address = address;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", items=" + items +
                ", amount=" + amount +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
