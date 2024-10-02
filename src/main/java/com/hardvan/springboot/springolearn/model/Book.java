package com.hardvan.springboot.springolearn.model;

import java.util.List;
import java.util.Set;

public class Book {
    // Attributes
    private String title;
    private String author;
    private String imageUrl;
    private String description;
    private Set<String> genres;
    private List<String> reviews;

    // Constructor
    public Book() {
    }

    public Book(String title, String author, String imageUrl, String description, Set<String> genres, List<String> reviews) {
        this.title = title;
        this.author = author;
        this.imageUrl = imageUrl;
        this.description = description;
        this.genres = genres;
        this.reviews = reviews;
    }

    // Getters and Setters
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", genres=" + genres +
                ", reviews=" + reviews +
                '}';
    }
}
