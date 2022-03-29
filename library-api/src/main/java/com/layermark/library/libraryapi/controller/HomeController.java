package com.layermark.library.libraryapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/home")
public class HomeController {

    @GetMapping(path="/hello")
    public @ResponseBody String greetUser(@RequestParam("name") String name){
        return String.format("Welcome %s", name);
    }
}