package com.hardvan.springboot.springolearn.controller;

import com.hardvan.springboot.springolearn.model.Book;
import com.hardvan.springboot.springolearn.service.BookFilter;
import com.hardvan.springboot.springolearn.service.BookService;
import com.hardvan.springboot.springolearn.service.BookSort;
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
    private BookService bookService;
    private BookFilter bookFilter;
    private BookSort bookSort;

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
    public String searchBooks(@RequestParam("query") String query, Model model, String byWhat) {
        List<Book> filteredBooks;

        // The if-else can be extended in case of other new criteria of filtration.
        if (byWhat.equals("title")) {
            filteredBooks = bookFilter.filterBooksByTitle(bookService.getAllBooks(), query);
        } else {
            filteredBooks = bookFilter.filterBooksByGenre(bookService.getAllBooks(), query);
        }

        model.addAttribute("books", filteredBooks);
        return "index";
    }

    @PostMapping("/sort")
    public void sortBooks(@RequestParam String order) {

        // The if-else can be extended in case of other new criteria of filtration
        switch (order) {
            case "reviewAscend":
                // Sort in ascending order.
                break;

            case "reviewDescend":
                // Sort in descending order.
                break;

            case "genre":
                // Sort depending on the singular genre selected.
                break;

            default:
                break; // None.
        }

    }
}
