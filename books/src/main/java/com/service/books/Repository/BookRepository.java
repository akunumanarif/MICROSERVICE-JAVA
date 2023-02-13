package com.service.books.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.books.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
