package com.prajyot.inventory.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prajyot.inventory.dto.InventoryResponseDTO;
import com.prajyot.inventory.entity.Inventory;
import com.prajyot.inventory.repository.InventoryRepository;
import com.prajyot.inventory.service.InventoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryRepository repository;

	@Override
	public List<InventoryResponseDTO> isInStock(List<String> skuCodes) {
		log.info("finding skucode in repository.....");
		return repository.findAllBySkuCodeIn(skuCodes).stream().map(this::mapToDTO).toList();
	}
	
	private InventoryResponseDTO mapToDTO(Inventory inventory) {
		return new InventoryResponseDTO(inventory.getSkuCode(),inventory.getQty());
	} 
}
