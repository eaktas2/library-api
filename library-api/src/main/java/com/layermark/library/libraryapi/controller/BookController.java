package com.layermark.library.libraryapi.controller;

import com.layermark.library.libraryapi.entity.Book;
import com.layermark.library.libraryapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/find/all")
    private List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/find/{id}")
    private Book getBookById(@PathVariable("id") int id){
        return bookService.getBookById(id);
    }

    @PostMapping("/add")
    private @ResponseBody String addBook(@RequestBody Book book){

        bookService.saveBook(book);

        return "Save Successful!";
    }


    @DeleteMapping("/delete/{id}")
    private String deleteBookById(@PathVariable("id") int id){

        bookService.deleteBook(id);
        return "Deletion Successful!";
    }


}
