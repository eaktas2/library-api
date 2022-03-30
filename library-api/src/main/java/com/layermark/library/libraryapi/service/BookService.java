package com.layermark.library.libraryapi.service;

import com.layermark.library.libraryapi.entity.Book;
import com.layermark.library.libraryapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(book ->books.add(book));
        return books;
    }



    public Book getBookById(int bookId){
        if (bookRepository.existsById(bookId))
            return bookRepository.findById(bookId).get();
        else
            return null;

    }

    public String deleteBook(int id){
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return "Deletion Successful!";
        }
        else
            return "Deletion Failed! No book exists for the given id";

    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }
}
