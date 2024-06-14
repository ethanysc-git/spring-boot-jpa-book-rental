package com.ethan.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.ethan.backend.dtos.InventoryDto;
import com.ethan.backend.mappers.InventoryMapper;
import com.ethan.backend.repositories.InventoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    public List<InventoryDto> allInventoryDtos() {
        return inventoryMapper.toInventoryDtos(inventoryRepository.findAll());
    }

}