package com.microservice.order_service.dto.response;

public class InventoryResponse {

    private String skuCode;
    private boolean inStock;

    // No-arg constructor
    public InventoryResponse() {
    }

    // All-args constructor
    public InventoryResponse(String skuCode, boolean inStock) {
        this.skuCode = skuCode;
        this.inStock = inStock;
    }

    // Getter and Setter
    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "InventoryResponse{" +
                "skuCode='" + skuCode + '\'' +
                ", inStock=" + inStock +
                '}';
    }
}

