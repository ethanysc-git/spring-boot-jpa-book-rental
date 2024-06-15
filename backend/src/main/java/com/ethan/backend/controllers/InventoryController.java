package com.ethan.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethan.backend.dtos.InventoryDto;
import com.ethan.backend.services.InventoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/records")
    public ResponseEntity<List<InventoryDto>> allInventoryDtos() {
        return ResponseEntity.ok(inventoryService.allInventoryDtos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryDto> getInventoryDto(@PathVariable UUID id) {
        return ResponseEntity.ok(inventoryService.getInventoryDto(id));
    }
}