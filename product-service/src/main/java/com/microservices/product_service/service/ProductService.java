package com.microservices.product_service.service;


import com.microservices.product_service.dto.request.ProductRequest;
import com.microservices.product_service.dto.response.ProductResponse;
import com.microservices.product_service.modal.Product;
import com.microservices.product_service.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public void create(ProductRequest productRequest){
        Product product=new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        productRepo.save(product);

    }
    public List<ProductResponse> getAllProducts(){
        List<Product> products=productRepo.findAll();
return products.stream().map(product -> mapToProductResponse(product)).collect(Collectors.toList());
    }

    public ProductResponse mapToProductResponse(Product product){
        ProductResponse productResponse=new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }
}
