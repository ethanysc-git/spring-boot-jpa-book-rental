package com.ethan.backend.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.ethan.backend.dtos.InventoryDto;
import com.ethan.backend.entities.Inventory;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    Inventory toInventory(InventoryDto inventoryDto);

    InventoryDto toInventoryDto(Inventory inventory);

    List<InventoryDto> toInventoryDtos(List<Inventory> inventories);
}