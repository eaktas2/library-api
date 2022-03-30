package com.layermark.library.libraryapi.controller;

import com.layermark.library.libraryapi.entity.Author;
import com.layermark.library.libraryapi.entity.Book;
import com.layermark.library.libraryapi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/find/all")
    private List<Author> getAllAuthors() throws Exception { return authorService.getAllAuthors();
    }

    @GetMapping("/find/{id}")
    private Author getAuthorById(@PathVariable("id") int id){
        return authorService.getAuthorById(id);
    }

    @PostMapping("/add")
    private @ResponseBody String addAuthor(@RequestBody Author author){

        authorService.saveAuthor(author);
        return "Save Successful!";
    }

    @GetMapping("/find/{id}/books")
    private List<Book> getAllBooksByAuthor(@PathVariable("id") int id){ return authorService.getAllBooksByAuthor(id);
    }


    @DeleteMapping("/delete/{id}")
    private String deleteAuthorById(@PathVariable("id") int id){
        return authorService.deleteAuthor(id);
    }
}
