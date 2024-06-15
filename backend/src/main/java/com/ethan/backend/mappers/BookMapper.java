package com.ethan.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import com.ethan.backend.dtos.BookDto;
import com.ethan.backend.entities.Book;


@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);


    Book toBook(BookDto bookDto);

    BookDto toBookDto(Book book);

    List<BookDto> toBookDtos(List<Book> books);

}