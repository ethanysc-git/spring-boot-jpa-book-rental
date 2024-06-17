package com.ethan.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethan.backend.dtos.BookDto;
import com.ethan.backend.dtos.InventoryDto;
import com.ethan.backend.services.BookService;
import com.ethan.backend.services.InventoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final InventoryService inventoryService;

    @GetMapping("/")
    public ResponseEntity<List<BookDto>> allBookDtos() {
        return ResponseEntity.ok(bookService.allBookDtos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookDto(@PathVariable UUID id) {
        return ResponseEntity.ok(bookService.getBookDto(id));
    }

    @PutMapping("/borrow")
    public ResponseEntity<InventoryDto> updateInventory(@RequestBody InventoryDto inventoryDto) {
        return ResponseEntity.ok(inventoryService.updateInventory(inventoryDto));
    }

    @PutMapping("/return")
    public ResponseEntity<InventoryDto> updateReturnInventory(@RequestBody InventoryDto inventoryDto) {
        return ResponseEntity.ok(inventoryService.updateReturnInventory(inventoryDto));
    }
}