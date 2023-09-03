package com.my.book.store.backend.mapper;

import com.my.book.store.backend.config.MapperConfig;
import com.my.book.store.backend.dto.CreateBookRequestDto;
import com.my.book.store.backend.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CreateBookRequestMapper {
    CreateBookRequestDto toDto(Book book);

    Book toModel(CreateBookRequestDto bookRequestDto);
}
