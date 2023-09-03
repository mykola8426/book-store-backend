package com.my.book.store.backend.mapper;

import com.my.book.store.backend.config.MapperConfig;
import com.my.book.store.backend.dto.BookDto;
import com.my.book.store.backend.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(BookDto bookDto);
}
