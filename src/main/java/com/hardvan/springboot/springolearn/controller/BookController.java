package com.hardvan.springboot.springolearn.controller;

import com.hardvan.springboot.springolearn.model.Book;
import com.hardvan.springboot.springolearn.service.BookService;
import com.hardvan.springboot.springolearn.service.BookFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookFilter bookFilter;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String index(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

    @PostMapping("/addReview")
    public String addReview(@RequestParam String title, @RequestParam String review) {
        bookService.addReview(title, review);
        return "redirect:/";
    }

    @PostMapping("/deleteAllReviews")
    public String deleteAllReviews(@RequestParam String title) {
        bookService.deleteAllReviews(title);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam String query, @RequestParam String searchType, Model model) {
        List<Book> books = bookService.getAllBooks();
        List<Book> filteredBooks;

        if ("title".equals(searchType)) {
            filteredBooks = bookFilter.filterBooksByTitle(books, query);
        } else if ("genre".equals(searchType)) {
            filteredBooks = bookFilter.filterBooksByGenre(books, query);
        } else {
            filteredBooks = books;
        }

        model.addAttribute("books", filteredBooks);
        return "index";
    }
}
