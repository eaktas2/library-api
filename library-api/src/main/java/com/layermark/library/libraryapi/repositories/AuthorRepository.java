package com.layermark.library.libraryapi.repositories;

import com.layermark.library.libraryapi.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
