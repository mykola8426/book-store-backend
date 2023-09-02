package com.my.book.store.backend.repository;

import com.my.book.store.backend.model.Book;
import java.util.List;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
