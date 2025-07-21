package com.microservice.order_service.dto.request;

import java.util.List;

public class OrderRequest {

    private List<OrderLineItemsDto> orderLineItemsDtos;

    public OrderRequest() {
    }

    public OrderRequest(List<OrderLineItemsDto> orderLineItemsDtos) {
        this.orderLineItemsDtos = orderLineItemsDtos;
    }

    public List<OrderLineItemsDto> getOrderLineItemsDtos() {
        return orderLineItemsDtos;
    }

    public void setOrderLineItemsDtos(List<OrderLineItemsDto> orderLineItemsDtos) {
        this.orderLineItemsDtos = orderLineItemsDtos;
    }
}
