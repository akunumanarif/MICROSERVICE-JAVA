package com.service.books.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/messages")
public class Book {

    @GetMapping
    public String getBook() {
        return "Hello world";
    }

    @PostMapping
    public String adBookList(@RequestBody String books) {
        // Ketika melakukan post method di POSTMAN, perlu ditambahkan body berupa text
        // karena permintaan nya "Hello world" maka isikan Hello wrld
        return books;
    }

    @DeleteMapping("/{id}")
    public String deleteMsg(@PathVariable("id") Long id) {
        return "Hello world";
    }

}
