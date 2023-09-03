package com.my.book.store.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Title is mandatory")
    private String title;
    @NotNull(message = "Author is mandatory")
    private String author;
    @NotNull(message = "ISBN is mandatory")
    @Column(unique = true)
    private String isbn;
    @NotNull(message = "Price is mandatory")
    private BigDecimal price;
    private String description;
    private String coverImage;
}
