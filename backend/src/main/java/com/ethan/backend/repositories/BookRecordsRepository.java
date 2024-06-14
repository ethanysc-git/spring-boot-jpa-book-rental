package com.ethan.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ethan.backend.entities.Book;

public interface BookRecordsRepository extends JpaRepository<Book, Long> {
}
