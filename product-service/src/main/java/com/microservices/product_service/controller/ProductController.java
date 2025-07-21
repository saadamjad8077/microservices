package com.microservices.product_service.controller;

import com.microservices.product_service.dto.request.ProductRequest;
import com.microservices.product_service.dto.response.ProductResponse;
import com.microservices.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
     public void create(@RequestBody ProductRequest productRequest){
        productService.create(productRequest);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
      return   productService.getAllProducts();
    }
}
