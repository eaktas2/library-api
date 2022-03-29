package com.layermark.library.libraryapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private int isbn;

    @Column
    private String name;

    @Column
    private String authors;

    @Column
    private int publishYear;

    @Column
    private String genre;

    @Column
    private String publisher;

    public Book(String name, String authors,
                int isbn, int publishYear, String genre,
                String publisher){
        this.name = name;
        this.isbn = isbn;
        this.authors = authors;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.genre = genre;
    }

}
