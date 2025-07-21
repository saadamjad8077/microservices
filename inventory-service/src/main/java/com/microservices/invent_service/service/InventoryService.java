package com.microservices.invent_service.service;

import com.microservices.invent_service.dto.response.InventoryResponse;
import com.microservices.invent_service.repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    @Autowired
    InventoryRepo inventoryRepo;
    public List<InventoryResponse> isInStock(List<String> skuCodes) {
        return inventoryRepo.findBySkuCodeIn(skuCodes).stream()
                .map(inventory -> {
                    InventoryResponse response = new InventoryResponse();
                    response.setSkuCode(inventory.getSku());
                    response.setInStock(inventory.getQuantity() > 0);
                    return response;
                })
                .collect(Collectors.toList());
    }

}

