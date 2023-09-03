package com.my.book.store.backend.service;

import com.my.book.store.backend.dto.BookDto;
import com.my.book.store.backend.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);
}
