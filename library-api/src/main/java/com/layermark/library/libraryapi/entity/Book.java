package com.layermark.library.libraryapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.layermark.library.libraryapi.service.AuthorService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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
    private String author_name;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="author_id")
    private Author author;

    @Column
    private int publishYear;

    @Column
    private String genre;

    @Column
    private String publisher;

    public Book(String name, String author,
                int isbn, int publishYear, String genre,
                String publisher, int author_id){
        this.name = name;
        this.isbn = isbn;
        this.author_name = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.genre = genre;
    }

}
