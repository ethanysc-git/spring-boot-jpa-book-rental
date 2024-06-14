package com.ethan.backend.mappers;

import org.mapstruct.Mapper;

import java.util.List;
import com.ethan.backend.dtos.BookDto;
import com.ethan.backend.entities.Book;


@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toAppUser(BookDto bookDto);

    BookDto toGymRecordDto(Book gymRecord);

    List<BookDto> toAppUserDtos(List<Book> books);

}