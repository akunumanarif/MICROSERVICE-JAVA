package com.service.books.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.books.Entity.Book;
import com.service.books.Service.BookService;
import com.service.books.dto.BookDTO;

import lombok.Data;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/books")
@Data
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public Iterable<Book> getBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public Book getOneBook(@PathVariable("id") Long bookId) {

        return bookService.findOneBook(bookId);
    }

    @PostMapping
    public ResponseEntity<BookDTO<Book>> addBook(@Valid @RequestBody Book book, Errors errors) {
        BookDTO<Book> bookData = new BookDTO<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                bookData.getMessage().add(error.getDefaultMessage());
            }

            bookData.setStatus(false);
            bookData.setPayloads(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bookData);
        }

        bookData.setStatus(true);
        bookData.setPayloads(bookService.saveBook(book));
        return ResponseEntity.ok(bookData);
    }

    @PutMapping
    public ResponseEntity<BookDTO<Book>> updateBook(@Valid @RequestBody Book book, Errors errors) {
        BookDTO<Book> bookData = new BookDTO<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                bookData.getMessage().add(error.getDefaultMessage());
            }

            bookData.setStatus(false);
            bookData.setPayloads(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bookData);
        }

        bookData.setStatus(true);
        bookData.setPayloads(bookService.saveBook(book));

        return ResponseEntity.ok(bookData);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long bookId) {
        bookService.deleteBook(bookId);
    }

}
