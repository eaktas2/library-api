package com.layermark.library.libraryapi.controller;

import com.layermark.library.libraryapi.entity.Author;
import com.layermark.library.libraryapi.entity.Book;
import com.layermark.library.libraryapi.service.AuthorService;
import com.layermark.library.libraryapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @GetMapping("/find/all")
    private List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/find/{id}")
    private Book getBookById(@PathVariable("id") int id){
        if  (bookService.getBookById(id) == null)
            return null;
        return bookService.getBookById(id);
    }

    @PostMapping("/add/{id}")
    private @ResponseBody String addBookByAuthor(@PathVariable("id") int author_id, @RequestBody Book book){

        if (authorService.getAuthorById(author_id) == null)
            return "No author was found for the given id";

        Author author = authorService.getAuthorById(author_id);
        if (book.getAuthor_name() == null){
            book.setAuthor(author);
            book.setAuthor_name(author.getName());
        }

        if (!author.getName().equals(book.getAuthor_name())){
            return "The author names do not match! Add Failed.";
        }

        bookService.saveBook(book);
        return "Save Successful!";
    }

    @PostMapping("/add")
    private @ResponseBody String addBook(@RequestBody Book book){

        List<Author> authors = authorService.getAllAuthors();
        for (Author author : authors){
            if (author.getName().equals(book.getAuthor_name())){
                book.setAuthor(author);
                bookService.saveBook(book);
                return "Save Successful!";
            }
        }

        return "Author is not found! Author must be added to the database first.";
    }


    @DeleteMapping("/delete/{id}")
    private String deleteBookById(@PathVariable("id") int id){
        return bookService.deleteBook(id);
    }


}
