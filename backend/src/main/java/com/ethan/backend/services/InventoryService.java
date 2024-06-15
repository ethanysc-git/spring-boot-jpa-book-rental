package com.ethan.backend.services;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ethan.backend.dtos.InventoryDto;
import com.ethan.backend.entities.Inventory;
import com.ethan.backend.exceptions.AppException;
import com.ethan.backend.mappers.InventoryMapper;
import com.ethan.backend.repositories.InventoryRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    public List<InventoryDto> allInventoryDtos() {
        return inventoryMapper.toInventoryDtos(inventoryRepository.findAll());
    }

    public InventoryDto getInventory(UUID id) {
        Inventory record = inventoryRepository.findById(id)
                .orElseThrow(() -> new AppException("Inventory record not found", HttpStatus.NOT_FOUND));
        return inventoryMapper.toInventoryDto(record);
    }

}