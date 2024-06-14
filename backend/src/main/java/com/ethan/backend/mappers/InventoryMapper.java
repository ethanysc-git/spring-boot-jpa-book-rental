package com.ethan.backend.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.ethan.backend.dtos.InventoryDto;
import com.ethan.backend.entities.Inventory;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    Inventory toAppUser(InventoryDto inventoryDto);

    InventoryDto toGymRecordDto(Inventory inventory);

    List<InventoryDto> toAppUserDtos(List<Inventory> inventories);
}