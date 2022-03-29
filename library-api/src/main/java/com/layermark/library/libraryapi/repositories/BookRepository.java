package com.layermark.library.libraryapi.repositories;

import com.layermark.library.libraryapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer> {

}
