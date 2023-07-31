package com.prajyot.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prajyot.inventory.dto.InventoryResponseDTO;

@Service
public interface InventoryService {

	List<InventoryResponseDTO> isInStock(List<String> skuCodes);

}
