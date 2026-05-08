package com.gowri_manikandan.Z_Kart.repository.dto;

public class Product {
    private long id;
    private String name;
    private double price;
    private int stock;
    private String model;
    private String category;
    private String brand;
    private boolean isActive;
    private long createdAt;

    // Default constructor
    public Product() {}

    // Constructor with parameters
    public Product(long id, String name, double price, int stock, String model, String category, String brand, boolean isActive, long createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.model = model;
        this.category = category;
        this.brand = brand;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    // Validation methods
    public boolean isValid() {
        return name != null && !name.trim().isEmpty() && price > 0 && stock >= 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", model='" + model + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                '}';
    }
}

