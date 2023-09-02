package com.my.book.store.backend.repository.impl;

import com.my.book.store.backend.exception.DatabaseException;
import com.my.book.store.backend.exception.EntityCreationException;
import com.my.book.store.backend.model.Book;
import com.my.book.store.backend.repository.BookRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public BookRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Book save(Book book) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            transaction.begin();
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
}
