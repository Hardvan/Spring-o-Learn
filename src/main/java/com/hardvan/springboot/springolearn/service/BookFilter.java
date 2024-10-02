package com.hardvan.springboot.springolearn.service;

import com.hardvan.springboot.springolearn.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing methods to filter books based on different characteristics.
 */
@Service
public class BookFilter {

    /**
     *
     * This method filters the books based on whether the searchQuery can be found in each book's title.
     *
     * @param books The list of books to be checked
     * @param searchQuery The query on which the books are to be filtered.
     * @return the filtered list of books.
     */
    public List<Book> filterBooksByTitle(List<Book> books, String searchQuery) {

        List<Book> booksByTitle = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
                booksByTitle.add(book);
            }
        }

        return booksByTitle;
    }

    /**
     *
     * This method filters the books based on whether the searchQuery can be found in each book's list of genres.
     *
     * @param books The list of books to be checked
     * @param searchQuery The query on which the books are to be filtered.
     * @return the filtered list of books.
     */
    public List<Book> filterBooksByGenre(List<Book> books, String searchQuery) {

        List<Book> booksByGenre = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenres().contains(searchQuery.toLowerCase())) {
                booksByGenre.add(book);
            }
        }

        return booksByGenre;
    }

}