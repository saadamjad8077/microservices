package com.microservices.product_service.dto.request;

public class ProductRequest {
    private String name;
    private String description;
    private double price;

    // Constructor (optional)
    public ProductRequest() {
    }

    public ProductRequest(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
