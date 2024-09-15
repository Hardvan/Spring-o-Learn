package com.hardvan.springboot.springolearn.service;

import com.hardvan.springboot.springolearn.model.Book;

import java.util.Comparator;
import java.util.List;

class ByReviews implements Comparator<Book> {
    public int compare(Book a, Book b){
        return Integer.compare(a.getReviews().size(), b.getReviews().size());
    }
}

class ByTitle implements Comparator<Book>{
    public int compare(Book a, Book b){
        return a.getTitle().compareTo(b.getTitle());
    }
}

public class BookSort {

    public List<Book> sortByReviews(List<Book> books, boolean reverse){

        if(reverse) books.sort(new ByReviews().reversed());
        else books.sort(new ByReviews());

        return books;
    }

    public List<Book> sortByTitle(List<Book> books, boolean reverse){

        if(reverse) books.sort(new ByTitle().reversed());
        else books.sort(new ByTitle());

        return books;
    }


}