package com.book.book.service;

import com.book.book.dto.request.BookRequest;
import com.book.book.entity.Book;
import com.book.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(BookRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublishedDate(request.getPublishedDate());
        book.setIsbn(request.getIsbn());
        book.setCoverImage(request.getCoverImage());
        book.setLanguage(request.getLanguage());
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(String bookId) {
        return bookRepository
                .findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book updateBook(String bookId, BookRequest request) {
        Book book = getBook(bookId);
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublishedDate(request.getPublishedDate());
        book.setIsbn(request.getIsbn());
        book.setCoverImage(request.getCoverImage());
        book.setLanguage(request.getLanguage());
        return bookRepository.save(book);
    }

    public void deleteBook(String bookId) {
        bookRepository.deleteById(bookId);
    }

}
