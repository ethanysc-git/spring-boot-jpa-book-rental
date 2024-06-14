package com.ethan.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.ethan.backend.dtos.BookDto;
import com.ethan.backend.mappers.BookMapper;
import com.ethan.backend.repositories.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookDto> allBookDtos() {
        return bookMapper.toBookDtos(bookRepository.findAll());
    }

}