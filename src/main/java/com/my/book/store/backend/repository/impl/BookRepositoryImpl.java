package com.my.book.store.backend.repository.impl;

import com.my.book.store.backend.exception.DatabaseException;
import com.my.book.store.backend.exception.EntityCreationException;
import com.my.book.store.backend.model.Book;
import com.my.book.store.backend.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    @Override
    public Book save(Book book) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
            return book;
        } catch (EntityCreationException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new EntityCreationException("Can't save book to DB: " + book, e);
        }

    }

    @Override
    public List<Book> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        } catch (RuntimeException e) {
            throw new DatabaseException("Can't find all books in DB", e);
        }
    }

    @Override
    public Optional<Book> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Book book = session.find(Book.class, id);
            return Optional.ofNullable(book);
        }
    }
}
