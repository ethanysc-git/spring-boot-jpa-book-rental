package com.ethan.backend.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.ethan.backend.dtos.InventoryDto;
import com.ethan.backend.entities.Inventory;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    Inventory toInventory(InventoryDto inventoryDto);

    InventoryDto toInventoryDto(Inventory inventory);

    List<InventoryDto> toInventoryDtos(List<Inventory> inventories);

    @Mapping(target = "id", ignore = false)
    @Mapping(target = "book_id", ignore = true)
    @Mapping(target = "user_id", ignore = true)
    @Mapping(target = "loan_date", ignore = true)
    void updateInventory(@MappingTarget Inventory target, Inventory source);

}