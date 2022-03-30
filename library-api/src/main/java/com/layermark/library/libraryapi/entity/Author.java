package com.layermark.library.libraryapi.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "AUTHOR")
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int author_id;

    @JsonManagedReference
    @OneToMany(mappedBy="author", cascade = CascadeType.REMOVE)
    private List<Book> books;

    @Column
    private String name;

    @Column
    private int birthYear;

    @Column
    private String email;

    public Author(String name, String email, int birthYear){
        this.name = name;
        this.birthYear = birthYear;
        this.email = email;
    }

}
