package com.gowri_manikandan.Z_Kart.repository.dto;

public class Order {
    private long id;
    private long customerId;
    private double amount;
    private enum status {PENDING,CONFIRMED,SHIPPED,DELIVERED,CANCELLED}
    private String address;
    private String date;
}
