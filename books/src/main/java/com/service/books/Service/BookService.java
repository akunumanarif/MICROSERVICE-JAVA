package com.service.books.Service;

import java.util.Optional;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.books.Entity.Book;
import com.service.books.Repository.BookRepository;

@Service
@TransactionScoped
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findOneBook(Long bookId) {
        Optional<Book> tempBook = bookRepository.findById(bookId);

        if (!tempBook.isPresent()) {
            return null;
        }

        return bookRepository.findById(bookId).get();
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
