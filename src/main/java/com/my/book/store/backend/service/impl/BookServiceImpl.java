package com.my.book.store.backend.service.impl;

import com.my.book.store.backend.dto.BookDto;
import com.my.book.store.backend.dto.CreateBookRequestDto;
import com.my.book.store.backend.exception.EntityNotFoundException;
import com.my.book.store.backend.mapper.BookMapper;
import com.my.book.store.backend.mapper.CreateBookRequestMapper;
import com.my.book.store.backend.model.Book;
import com.my.book.store.backend.repository.BookRepository;
import com.my.book.store.backend.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final CreateBookRequestMapper createBookRequestMapper;

    @Override
    public BookDto save(CreateBookRequestDto createBookRequestDto) {
        Book book = createBookRequestMapper.toModel(createBookRequestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't find book by id " + id));
        return bookMapper.toDto(book);
    }
}
