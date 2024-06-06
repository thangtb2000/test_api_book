package com.book.book.controller;
import com.book.book.dto.request.BookRequest;
import com.book.book.entity.Book;
import com.book.book.exception.BookNotFoundException;
import com.book.book.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setPublishedDate(bookRequest.getPublishedDate());
        book.setIsbn(bookRequest.getIsbn());
        book.setNumberOfPages(bookRequest.getNumberOfPages());
        book.setCoverImage(bookRequest.getCoverImage());
        book.setLanguage(bookRequest.getLanguage());

        Book savedBook = bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @Valid @RequestBody BookRequest bookRequest) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setPublishedDate(bookRequest.getPublishedDate());
        book.setIsbn(bookRequest.getIsbn());
        book.setNumberOfPages(bookRequest.getNumberOfPages());
        book.setCoverImage(bookRequest.getCoverImage());
        book.setLanguage(bookRequest.getLanguage());
        Book updatedBook = bookRepository.save(book);

        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        bookRepository.delete(book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
