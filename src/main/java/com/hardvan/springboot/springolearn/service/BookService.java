package com.hardvan.springboot.springolearn.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hardvan.springboot.springolearn.model.Book;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BookService {

    private List<Book> books;

    public BookService() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        books = objectMapper.readValue(new File(
                "src/main/resources/books_data.json"),
                new TypeReference<List<Book>>() {});
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addReview(String title, String review) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.getReviews().add(review);
                break;
            }
        }
    }
}
