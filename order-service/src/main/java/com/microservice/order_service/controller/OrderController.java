package com.microservice.order_service.controller;

import com.microservice.order_service.dto.request.OrderRequest;
import com.microservice.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;
@PostMapping("/placeOrder")
@ResponseStatus(HttpStatus.CREATED)
     public String placeOrder(@RequestBody OrderRequest orderRequest){
    orderService.placeOrder(orderRequest);
         return "order placed successfully";

     }
}
