package com.hardvan.springboot.springolearn.service;

import com.hardvan.springboot.springolearn.model.Book;

import java.util.Comparator;
import java.util.List;

/**
 * Comparator to compare two books by number of reviews.
 */
class ByReviews implements Comparator<Book> {

    /**
     *
     * @param a the first object to be compared.
     * @param b the second object to be compared.
     * @return value depending on the comparison between the number of reviews of book a to that of book b
     */
    public int compare(Book a, Book b){
        return Integer.compare(a.getReviews().size(), b.getReviews().size());
    }
}

/**
 * Comparator to compare two books by lexicographical title order.
 */
class ByTitle implements Comparator<Book>{

    /**
     *
     * @param a the first object to be compared.
     * @param b the second object to be compared.
     * @return value depending on the comparison between the lexicographical order of title of book a to that of book b
     */
    public int compare(Book a, Book b){
        return a.getTitle().compareTo(b.getTitle());
    }
}

/**
 * Class containing method to sort books on different parameters.
 */
public class BookSort {

    /**
     *
     * This method sorts books depending on the reviews and the sorting order selected by the user.
     *
     * @param books the list of books to search
     * @param reverse the truth value of whether the books are to be sorted in reverse order
     * @return the sorted list of books by reviews
     */
    public List<Book> sortByReviews(List<Book> books, boolean reverse){

        if(reverse) books.sort(new ByReviews().reversed());
        else books.sort(new ByReviews());

        return books;
    }

    /**
     *
     * This method sorts books depending on the title (lexicographically) and the sorting order selected by the user.
     *
     * @param books the list of books to search
     * @param reverse the truth value of whether the books are to be sorted in reverse order
     * @return the sorted list of books by title (lexicographical order)
     */
    public List<Book> sortByTitle(List<Book> books, boolean reverse){

        if(reverse) books.sort(new ByTitle().reversed());
        else books.sort(new ByTitle());

        return books;
    }


}