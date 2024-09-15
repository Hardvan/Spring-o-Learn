package com.hardvan.springboot.springolearn.service;

import com.hardvan.springboot.springolearn.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookFilter {

    public List<Book> filterBooksByTitle(List<Book> books, String searchQuery){

        List<Book> booksByTitle = new ArrayList<>();
        for(Book book : books){
            if(book.getTitle().toLowerCase().contains(searchQuery.toLowerCase())){
                booksByTitle.add(book);
            }
        }

        return booksByTitle;
    }

    public List<Book> filterBooksByGenre(List<Book> books, String searchQuery){

        List<Book> booksByGenre = new ArrayList<>();
        for(Book book : books){
            if(book.getGenres().contains(searchQuery.toLowerCase())){
                booksByGenre.add(book);
            }
        }

        return booksByGenre;
    }

}