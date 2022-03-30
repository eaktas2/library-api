package com.layermark.library.libraryapi.service;

import com.layermark.library.libraryapi.entity.Author;
import com.layermark.library.libraryapi.entity.Book;
import com.layermark.library.libraryapi.repositories.AuthorRepository;
import com.layermark.library.libraryapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public List<Author> getAllAuthors(){
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(author ->authors.add(author));
        return authors;
    }

    public Author getAuthorById(int authorId){
        if (authorRepository.existsById(authorId))
            return authorRepository.findById(authorId).get();
        else
            return null;
    }

    public List<Book> getAllBooksByAuthor(int authorId){
        if (authorRepository.existsById(authorId))
            return this.getAuthorById(authorId).getBooks();
        else
            return null;
    }

    public String deleteAuthor(int id){
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            return "Deletion Successful!";
        }
        else
            return "Deletion Failed! No Author exists for the given id";
    }

    public void saveAuthor(Author author){
        authorRepository.save(author);
    }

}
