package com.my.book.store.backend.service;

import com.my.book.store.backend.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
