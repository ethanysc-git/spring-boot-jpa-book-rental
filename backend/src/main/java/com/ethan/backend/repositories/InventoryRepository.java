package com.ethan.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ethan.backend.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}