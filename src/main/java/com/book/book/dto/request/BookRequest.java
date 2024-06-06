package com.book.book.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class BookRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    @NotNull(message = "Published date is required")
    @PastOrPresent(message = "Published date must be in the past or required")
    private LocalDate publishedDate;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    @NotNull(message = "Number date is required")
    @Positive(message = "Number of pages must be greater than 0")
    private int numberOfPages;

    @NotBlank(message = "Cover image URL is required")
    @Size(max = 255, message = "Cover image URL cannot be longer than 255 characters")
    private String coverImage;

    @NotBlank(message = "Language is required")
    private String language;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
