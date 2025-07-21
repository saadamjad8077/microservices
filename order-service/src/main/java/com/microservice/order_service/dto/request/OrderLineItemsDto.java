package com.microservice.order_service.dto.request;

public class OrderLineItemsDto {

    private Long id;
    private String sku;
    private double price;
    private int quantity;

    public OrderLineItemsDto() {
    }

    public OrderLineItemsDto(Long id, String sku, double price, int quantity) {
        this.id = id;
        this.sku = sku;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
