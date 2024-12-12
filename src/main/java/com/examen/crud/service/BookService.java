package com.examen.crud.service;

import com.examen.crud.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    private Long nextId = 1L;

    public List<Book> getBooks() {

        return books;
    }

    public Book addBook(Book book) {

        book.setId(nextId++);

        books.add(book);

        return book;
    }

    public boolean removeBook(Long id) {

        return books
                .removeIf(b -> b.getId().equals(id));
    }

    public Optional<Book> editBook(Long id, Book book) {

        Optional<Book> getedBook = getBookById(id);

        getedBook.ifPresent(b -> {

            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
            b.setThumbnail(book.getThumbnail());
        });

        return getedBook;
    }

    public Optional<Book> getBookById(Long id) {

        return books
                .stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }
}
