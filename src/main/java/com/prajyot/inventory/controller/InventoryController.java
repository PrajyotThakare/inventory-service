package com.prajyot.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prajyot.inventory.dto.InventoryResponseDTO;
import com.prajyot.inventory.service.InventoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	@Autowired
	private InventoryService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<InventoryResponseDTO> isInStock(@RequestParam("skuCodes")List<String> skuCodes) {
		log.info("searching wheather skucode {} is present....",skuCodes);
		return service.isInStock(skuCodes);
	}
}
