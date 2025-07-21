package com.microservice.order_service.service;

import com.microservice.order_service.dto.request.OrderLineItemsDto;
import com.microservice.order_service.dto.request.OrderRequest;
import com.microservice.order_service.dto.response.InventoryResponse;
import com.microservice.order_service.modal.Order;
import com.microservice.order_service.modal.OrderLineItems;
import com.microservice.order_service.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    WebClient.Builder webClientBuilder;
    public void placeOrder(OrderRequest orderRequest){
        Order order=new Order();
        order.setOrderNumber(String.valueOf(UUID.randomUUID()));
     List<OrderLineItems> orderLineItemsList=  orderRequest.getOrderLineItemsDtos().stream().map(orderLineItemsDto -> mapToDto(orderLineItemsDto)).toList();
     order.setOrderLineItemsList(orderLineItemsList);
     List<String> skuCodes=orderLineItemsList.stream().map(orderLineItems -> orderLineItems.getSku()).collect(Collectors.toList());

    InventoryResponse[] inventoryResponsesArray= webClientBuilder.build().get()
                     .uri("http://invent-service/api/inventory",uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                             .retrieve()
                                     .bodyToMono(InventoryResponse[].class)
                                             .block();
     boolean allProductsInStock=Arrays.stream(inventoryResponsesArray).allMatch(inventoryResponse -> inventoryResponse.isInStock());
    if(allProductsInStock){
     orderRepo.save(order);}
    else{
throw new RuntimeException("Product not found");
    }}
    public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setSku(orderLineItemsDto.getSku());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }
}
