package com.ethan.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethan.backend.dtos.BookDto;
import com.ethan.backend.services.BookService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/records")
    public ResponseEntity<List<BookDto>> allBookDtos() {
        return ResponseEntity.ok(bookService.allBookDtos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getGymRecord(@PathVariable UUID id) {
        return ResponseEntity.ok(bookService.getBookDto(id));
    }
}