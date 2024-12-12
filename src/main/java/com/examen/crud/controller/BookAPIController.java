package com.examen.crud.controller;

import com.examen.crud.model.Book;
import com.examen.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class BookAPIController {

    private final BookService bookService;

    @Autowired
    public BookAPIController(BookService bookService) {

        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {

        return bookService
                .getBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {

        Optional<Book> book = bookService
                .getBookById(id);

        return book
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {

        return bookService
                .addBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody Book book) {

        Optional<Book> currBook = bookService
                .editBook(id, book);

        return currBook
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {

        if (bookService.removeBook(id)) {

            return ResponseEntity.ok().build();
        }
        else {

            return ResponseEntity.notFound().build();
        }
    }
}
